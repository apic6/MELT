/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbgm8je3
 */
public class QuestionPaperTaker {
    QuestionPaper paper;
    StudentSubmission submission;
    int studentID;
    
    QuestionPaperTaker(QuestionPaper paper, int studentID) {
        this.paper = paper;
        this.studentID = studentID;
        
        submission = new StudentSubmission(paper.getPaperID(), studentID);
        // each section
        for (int i = 0; i<paper.getNumberOfSections(); i++) {
            Section section = paper.getSection(i);
            SubmissionSection submSection = new SubmissionSection(i);
            submission.addSection(submSection);
            // each subsection
            for (int j = 0; j<section.getNumberOfSubSections(); j++) {
                SubSection subSection = section.getSubSection(j);
                SubmissionSubSection submSubSection = new SubmissionSubSection(j);
                submSection.addSubSection(submSubSection);
            } // subsections
        } // sections
    }
    
    void answerQuestion(int sectionID, int subSectionID, int questionID, int answer) {
        MCQAnswer mcqAnswer = new MCQAnswer(questionID, answer);
        submission.getSection(sectionID).getSubSection(subSectionID).addAnswer(mcqAnswer);
    }
    
    void answerQuestion(int sectionID, int subSectionID, int questionID, String answer) {
        FITBAnswer fitbAnswer = new FITBAnswer(questionID, answer);
        submission.getSection(sectionID).getSubSection(subSectionID).addAnswer(fitbAnswer);
    }
    
    void saveSubmission(String filename) throws FileNotFoundException {
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
