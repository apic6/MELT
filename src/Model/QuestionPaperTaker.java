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
import Model.questionPaper.MBQuestion;
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
                submSection.addSubSection(submSubSection);
                for (int k = 0; k < subSection.getNumberOfQuestions(); k++) {
                    System.out.println("Adding question " + k);
                    Question q = subSection.getQuestion(k);
                    if (q instanceof MultipleChoiceQuestion) {
                        MCQAnswer mcqAnswer = new MCQAnswer(k, -1);
                    } else {
                        FITBAnswer fitbAnswer = new FITBAnswer(k, "null");
                    }
                }
            } // subsections
        } // sections
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
