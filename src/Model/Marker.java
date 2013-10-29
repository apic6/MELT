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

    public ArrayList<Answer> getMarkableAnswers() {
        if (subm == null) {
            return null;
        }
        return subm.getMarkableAnswers();
    }

    public void markQuestion(Answer ans, int givenMark) {
        if (ans instanceof EssayAnswer) {
            EssayAnswer answer = (EssayAnswer) ans;
            SubmissionSubSection submSubSection = subm.getSection(answer.getSectionID()).getSubSection(answer.getSubSectionAtIndex(0));
            for (int i = 1; i<answer.getSizeOfSubSectionList(); i++) {
                submSubSection = submSubSection.getSubSection(answer.getSubSectionAtIndex(i));
            }
            submSubSection.getAnswer(answer.getID()).setMarked(true);
            submSubSection.getAnswer(answer.getID()).setMark(givenMark);
            mark += givenMark;
        } else if (ans instanceof MFITBAnswer) {
            MFITBAnswer answer = (MFITBAnswer) ans;
            SubmissionSubSection submSubSection = subm.getSection(answer.getSectionID()).getSubSection(answer.getSubSectionAtIndex(0));
            for (int i = 1; i<answer.getSizeOfSubSectionList(); i++) {
                submSubSection = submSubSection.getSubSection(answer.getSubSectionAtIndex(i));
            }
            submSubSection.getAnswer(answer.getID()).setMarked(true);
            submSubSection.getAnswer(answer.getID()).setMark(givenMark);
            mark += givenMark;
        }
    }

    public void markSubSection(SubmissionSubSection submSubSection, SubSection subSection) {
        // mark questions
        if (subSection.getCollectionType() == SubSection.CollectionType.QUESTIONS) {
            for (int i = 0; i < submSubSection.getSize(); i++) {
                if (submSubSection.getAnswer(i) instanceof MCQAnswer) {
                    // if correct answer
                    MCQAnswer submAnswer = (MCQAnswer) submSubSection.getAnswer(i);
                    MultipleChoiceQuestion question = (MultipleChoiceQuestion) subSection.getQuestion(i);
                    for (int l = 0; l < question.getNumberOfPossibleAnswers(); l++) {
                        if (submAnswer.getAnswer() == -1) {
                            // didn't answer;
                            submAnswer.setMark(0);
                        } else if (submAnswer.getAnswer() == question.getPossibleAnswer(l)) {
                            submAnswer.setMark(question.getMark());
                            mark += question.getMark(); //question.getMark();
                            break;
                        }
                    }
                    // right or wrong increase total mark

                } else if (submSubSection.getAnswer(i) instanceof FITBAnswer) { // else it was FITB Question
                    FITBAnswer submAnswer = (FITBAnswer) submSubSection.getAnswer(i);
                    FITBQuestion question = (FITBQuestion) subSection.getQuestion(i);
                    for (int l = 0; l < question.getNumberOfPossibleAnswers(); l++) {
                        if (submAnswer.getAnswer() == null) {
                            // didn't answer;
                            submAnswer.setMark(0);
                        } else if (submAnswer.getAnswer().equals(question.getPossibleAnswer(l))) {
                            submAnswer.setMark(question.getMark());
                            mark += question.getMark();
                            break;
                        }
                    }
                } // else FITBQ 
                totalMark += subSection.getQuestion(i).getMark();
            } // questions
        } else if (subSection.getCollectionType() == SubSection.CollectionType.SUBSECTIONS) {
            for (int i = 0; i < submSubSection.getSize(); i++) {
                SubmissionSubSection submissionSubSectionN = submSubSection.getSubSection(i);
                SubSection subSectionN = subSection.getSubSection(i);

                markSubSection(submissionSubSectionN, subSectionN);
            }
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

                    markSubSection(submissionSubSection, subSection);
                } // subSections
            } // sections

            return true;
        } else {
            return false;
        }
    }

    public void updateMark() {
        // TODO
        return;
    }

    public Submission getSubmission() {
        return subm;
    }

    public int getMark() {
        return mark;
    }

    public int getTotalMark() {
        return totalMark;
    }
}
