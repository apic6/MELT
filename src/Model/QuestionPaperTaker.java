/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.Section;
import Model.questionPaper.Question;
import Model.questionPaper.QuestionPaper;
import Model.questionPaper.SubSection;
import Model.questionPaper.MultipleChoiceQuestion;
import Model.StudentSubmission.*;
import Model.questionPaper.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbgm8je3
 */
public class QuestionPaperTaker {

    QuestionPaper paper;
    Submission submission;
    int studentID;

    public QuestionPaperTaker(QuestionPaper paper, int studentID) {
        this.paper = paper;
        this.studentID = studentID;

        submission = new Submission(paper.getPaperID(), studentID);
        // each section
        for (int i = 0; i < paper.getNumberOfSections(); i++) {
            Section section = paper.getSection(i);
            SubmissionSection submSection = new SubmissionSection(i);
            submission.addSection(submSection);
            // each subsection
            for (int j = 0; j < section.getNumberOfSubSections(); j++) {
                SubSection subSection = section.getSubSection(j);
                SubmissionSubSection submSubSection = new SubmissionSubSection(j);
                
                ArrayList<Integer> subSectionIDs = new ArrayList<>();
                subSectionIDs.add(j);
                populateSubmissionSubSection(submSubSection, subSection, i, subSectionIDs);
                
                submSection.addSubSection(submSubSection);
                
                /* if (subSection.getCollectionType() == SubSection.CollectionType.QUESTIONS) {
                    submSection.addSubSection(submSubSection);
                    for (int k = 0; k < subSection.getNumberOfQuestions(); k++) {
                        Question q = subSection.getQuestion(k);
                        if (q instanceof MultipleChoiceQuestion) {
                            MCQAnswer mcqAnswer = new MCQAnswer(k, -1);
                            submSubSection.addAnswer(mcqAnswer);
                        } else if (q instanceof FITBQuestion) {
                            FITBAnswer fitbAnswer = new FITBAnswer(k, null);
                            submSubSection.addAnswer(fitbAnswer);
                        } else if (q instanceof EssayQuestion) {
                            EssayAnswer eAnswer = new EssayAnswer(i, j, k, "Student didn't answer");
                            submSubSection.addAnswer(eAnswer);
                        } else if (q instanceof MBQuestion) {
                            ArrayList<String> list = null;
                            MFITBAnswer mAnswer = new MFITBAnswer(i, j, k, list);
                            submSubSection.addAnswer(mAnswer);
                        }
                    }
                } else if (subSection.getCollectionType() == SubSection.CollectionType.SUBSECTIONS) {
                    for (int k = 0; k < subSection.getNumberOfSubSections(); k++) {
                        ArrayList<Integer> subSectionIDs = new ArrayList<>();
                        subSectionIDs.add(k);
                        populateSubmissionSubSection(submSubSection, subSection, i, subSectionIDs);
                        submSection.addSubSection(submSubSection);
                    }
                } */
            } // subsections
        } // sections
    }

    private void populateSubmissionSubSection(SubmissionSubSection submSubSection, SubSection subSection, int sectionID, ArrayList<Integer> subSectionIDs) {
        if (subSection.getCollectionType() == SubSection.CollectionType.SUBSECTIONS) {
            for (int i = 0; i < subSection.getNumberOfSubSections(); i++) {
                SubmissionSubSection submSectionn = new SubmissionSubSection(i);
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j<subSectionIDs.size(); j++) {
                    list.add(subSectionIDs.get(j));
                }
                list.add(i);
                populateSubmissionSubSection(submSectionn, subSection.getSubSection(i), sectionID, list);
                submSubSection.addSubSection(submSectionn);
            }
        } else if (subSection.getCollectionType() == SubSection.CollectionType.QUESTIONS) {
            for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
                Question q = subSection.getQuestion(i);
                if (q instanceof MultipleChoiceQuestion) {
                    MCQAnswer mcqAnswer = new MCQAnswer(i, -1);
                    submSubSection.addAnswer(mcqAnswer);
                } else if (q instanceof FITBQuestion) {
                    FITBAnswer fitbAnswer = new FITBAnswer(i, null);
                    submSubSection.addAnswer(fitbAnswer);
                } else if (q instanceof EssayQuestion) {
                    EssayAnswer eAnswer = new EssayAnswer(sectionID, subSectionIDs, i, "Student didn't answer");
                    submSubSection.addAnswer(eAnswer);
                } else if (q instanceof MBQuestion) {
                    ArrayList<String> list = null;
                    MFITBAnswer mAnswer = new MFITBAnswer(sectionID, subSectionIDs, i, list);
                    submSubSection.addAnswer(mAnswer);
                }
            }
        }
    }

    public void answerQuestion(int sectionID, int subSectionID, int questionID, int answer) {
        MCQAnswer mcqAnswer = new MCQAnswer(questionID, answer);
        submission.getSection(sectionID).getSubSection(subSectionID).addAnswer(mcqAnswer);
    }

    public void answerQuestionFITB(int sectionID, int subSectionID, int questionID, String answer) {
        FITBAnswer fitbAnswer = new FITBAnswer(questionID, answer);
        submission.getSection(sectionID).getSubSection(subSectionID).addAnswer(fitbAnswer);
    }

    public void answerQuestion(int sectionID, int subSectionID, int questionID, ArrayList<String> answers) {
        MFITBAnswer mbAnswer = new MFITBAnswer(sectionID, subSectionID, questionID, answers);
        submission.getSection(sectionID).getSubSection(subSectionID).addAnswer(mbAnswer);
    }

    public void answerQuestionEssay(int sectionID, int subSectionID, int questionID, String answer) {
        EssayAnswer essayAnswer = new EssayAnswer(sectionID, subSectionID, questionID, answer);
        submission.getSection(sectionID).getSubSection(subSectionID).addAnswer(essayAnswer);
    }

    public void answerQuestion(int sectionID, ArrayList<Integer> subSectionIDs, int questionID, int answer) {
        MCQAnswer mcqAnswer = new MCQAnswer(questionID, answer);
        SubmissionSubSection sSection = submission.getSection(sectionID).getSubSection(subSectionIDs.get(0));
        for (int i = 1; i < subSectionIDs.size(); i++) {
            sSection = sSection.getSubSection(subSectionIDs.get(i));
        }
        sSection.addAnswer(mcqAnswer);
    }

    public void answerQuestionFITB(int sectionID, ArrayList<Integer> subSectionIDs, int questionID, String answer) {
        FITBAnswer fitbAnswer = new FITBAnswer(questionID, answer);
        SubmissionSubSection sSection = submission.getSection(sectionID).getSubSection(subSectionIDs.get(0));
        for (int i = 1; i < subSectionIDs.size(); i++) {
            sSection = sSection.getSubSection(subSectionIDs.get(i));
        }
        sSection.addAnswer(fitbAnswer);
    }

    public void answerQuestion(int sectionID, ArrayList<Integer> subSectionIDs, int questionID, ArrayList<String> answers) {
        MFITBAnswer mbAnswer = new MFITBAnswer(sectionID, subSectionIDs, questionID, answers);
        SubmissionSubSection sSection = submission.getSection(sectionID).getSubSection(subSectionIDs.get(0));
        for (int i = 1; i < subSectionIDs.size(); i++) {
            sSection = sSection.getSubSection(subSectionIDs.get(i));
        }
        sSection.addAnswer(mbAnswer);
    }

    public void answerQuestionEssay(int sectionID, ArrayList<Integer> subSectionIDs, int questionID, String answer) {
        EssayAnswer essayAnswer = new EssayAnswer(sectionID, subSectionIDs, questionID, answer);
        SubmissionSubSection sSection = submission.getSection(sectionID).getSubSection(subSectionIDs.get(0));
        for (int i = 1; i < subSectionIDs.size(); i++) {
            sSection = sSection.getSubSection(subSectionIDs.get(i));
        }
        sSection.addAnswer(essayAnswer);
    }

    public Submission getSubmission() {
        return submission;
    }

    public void saveSubmission(String filename) throws FileNotFoundException {
        PrintWriter writer;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println(submission.toXML());
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Modeller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
