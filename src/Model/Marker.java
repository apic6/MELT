/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.*;
import Model.StudentSubmission.*;
import java.util.ArrayList;

/**
 *
 * @author mbgm8je3
 */
public class Marker {

    private int mark;
    private int totalMark;
    private Submission subm;

    public Marker() {
        subm = null;
        mark = 0;
        totalMark = 0;
    }

    public Marker(Submission subm) {
        this.subm = subm;
        mark = subm.getMark();
        totalMark = subm.getTotalMark();
    }

    public ArrayList<Answer> getUnmarkedAnswers() {
        if (subm == null) {
            return null;
        }
        return subm.getUnmarkedQuestions();
    }

    public void markQuestion(Answer ans, int givenMark) {
        if (ans instanceof EssayAnswer) {
            EssayAnswer answer = (EssayAnswer) ans;
            subm.getSection(answer.getSectionID()).getSubSection(answer.getSubSectionID()).getAnswer(answer.getID()).setMarked(true);
            subm.getSection(answer.getSectionID()).getSubSection(answer.getSubSectionID()).getAnswer(answer.getID()).setMark(givenMark);
            mark += givenMark;
        } else if (ans instanceof MFITBAnswer) {
            MFITBAnswer answer = (MFITBAnswer) ans;
            subm.getSection(answer.getSectionID()).getSubSection(answer.getSubSectionID()).getAnswer(answer.getID()).setMarked(true);
            subm.getSection(answer.getSectionID()).getSubSection(answer.getSubSectionID()).getAnswer(answer.getID()).setMark(givenMark);
            mark += givenMark;
        }
    }

    public boolean markTest(Submission submission, QuestionPaper paper) {
        mark = 0;
        totalMark = 0;
        this.subm = submission;
        if (submission.getPaperID() == paper.getPaperID()) {
            // mark sections
            for (int i = 0; i < submission.getSize(); i++) {
                // get section
                SubmissionSection submissionSection = submission.getSection(i);
                Section section = paper.getSection(i);

                if (submission.getSize() != paper.getNumberOfSections()) {
                    System.out.println("Number of sections in paper differ");
                }

                // mark subsections
                for (int j = 0; j < submissionSection.getSize(); j++) {
                    // get subSections
                    if (submissionSection.getSize() != section.getNumberOfSubSections()) {
                        System.out.println("Number of subsections in section " + j + " differ");
                    }

                    SubmissionSubSection submissionSubSection = submissionSection.getSubSection(j);
                    SubSection subSection = section.getSubSection(j);
                    // mark questions
                    for (int k = 0; k < submissionSubSection.getSize(); k++) {
                        // if question was a MCQ Question
                        if (submissionSubSection.getSize() != subSection.getNumberOfQuestions()) {
                            System.out.println("Number of questions in section " + j + " and subsection " + k + " differ");
                            System.out.println("Number of questions in subm. = " + submissionSubSection.getSize());
                            System.out.println("Number of questions in paper. = " + subSection.getNumberOfQuestions());
                        }
                        if (submissionSubSection.getAnswer(k) instanceof MCQAnswer) {
                            // if correct answer
                            MCQAnswer submAnswer = (MCQAnswer) submissionSubSection.getAnswer(k);
                            MultipleChoiceQuestion question = (MultipleChoiceQuestion) subSection.getQuestion(k);
                            for (int l = 0; l < question.getNumberOfPossibleAnswers(); l++) {
                                System.out.println("Checking mark for section:" + i + " subsection " + j + " question");
                                if (submAnswer.getAnswer() == question.getPossibleAnswer(l)) {
                                    submAnswer.setMark(question.getMark());
                                    mark += question.getMark(); //question.getMark();
                                }
                            }
                            // right or wrong increase total mark

                        } else if (submissionSubSection.getAnswer(k) instanceof FITBAnswer) { // else it was FITB Question
                            FITBAnswer submAnswer = (FITBAnswer) submissionSubSection.getAnswer(k);
                            FITBQuestion question = (FITBQuestion) subSection.getQuestion(k);
                            for (int l = 0; l < question.getNumberOfPossibleAnswers(); l++) {
                                if (submAnswer.getAnswer().equals(question.getPossibleAnswer(l))) {
                                    submAnswer.setMark(question.getMark());
                                    mark += question.getMark();
                                    break;
                                }
                            }
                        } // else FITBQ 
                        totalMark += subSection.getQuestion(k).getMark();
                    } // questions
                } // subSections
            } // sections

            return true;
        } else {
            return false;
        }
    }

    public int getMark() {
        return mark;
    }

    public int getTotalMark() {
        return totalMark;
    }
}
