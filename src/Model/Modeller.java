/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//Should be able to handle data request and manipulate persistent data

import Model.xmlLoaders.SubmissionLoader;
import Model.xmlLoaders.QuestionPaperLoader;
import Model.questionPaper.QuestionPaper;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.StudentSubmission.*;

/**
 *
 * @author mbaxkak4
 */
public class Modeller {

    private static ArrayList<QuestionPaper> questionPapers;
    private static ArrayList<Submission> submissions;
    QuestionPaper viewingPaper;

    public Modeller() {     //constructor
    }

    public void init() {
        loadPapers();
        loadSubmissions();
    }

    public void loadPapers() {
        loadPapers("papers/Papers.xml");
    }

    // loads all papers into model
    public void loadPapers(String filename) {
        QuestionPaperLoader loader = new QuestionPaperLoader(filename);

        loader.readPapers();

        questionPapers = loader.getQuestionPapers();
    }

    public int getNextID() {
        return questionPapers.get(getNumberOfPapers() - 1).getPaperID() + 1;
    }

    // saves papers
    public void savePapers(String filename) throws FileNotFoundException {
        String xmlString = "<QuestionPapers>";
        if (filename == null) {
            filename = "papers/Papers.xml";
        }
        for (int i = 0; i < questionPapers.size(); i++) {
            xmlString += questionPapers.get(i).toXML();
        }
        xmlString += "</QuestionPapers>";

        PrintWriter writer;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println(xmlString);
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Modeller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveSubmissions(String filename) throws FileNotFoundException {
        String xmlString = "<Submissions>";
        if (filename == null) {
            filename = "submissions/Submissions.xml";
        }
        for (int i = 0; i < submissions.size(); i++) {
            xmlString += submissions.get(i).toXML();
        }
        xmlString += "</Submissions>";

        PrintWriter writer;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println(xmlString);
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Modeller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<QuestionPaper> getPapers() {
        loadPapers();
        return questionPapers;
    }

    public ArrayList<QuestionPaper> getPapersByStudentID(int studentID) {
        ArrayList<QuestionPaper> eligiblePapers = new ArrayList<>();
        for (int i = 0; i < questionPapers.size(); i++) {
            if (questionPapers.get(i).isStudentEligible(studentID)) {
                eligiblePapers.add(questionPapers.get(i));
            }
        }
        return eligiblePapers;
    }

    public ArrayList<Submission> getSubmissionsByStudentID(int studentID) {
        ArrayList<Submission> studentsSubmissions = new ArrayList<>();
        for (int i = 0; i < submissions.size(); i++) {
            if (submissions.get(i).getStudentID() == studentID
                    && submissions.get(i).isSubmitted()) {
                studentsSubmissions.add(submissions.get(i));
            }
        }
        return studentsSubmissions;
    }

    public ArrayList<Submission> getMarkedSubmissionsByStudentID(int studentID) {
        ArrayList<Submission> studentsSubmissions = new ArrayList<>();
        for (int i = 0; i < submissions.size(); i++) {
            if (submissions.get(i).getStudentID() == studentID
                    && submissions.get(i).isSubmitted()
                    && submissions.get(i).isFullyMarked()) {
                studentsSubmissions.add(submissions.get(i));

            }

        }
        return studentsSubmissions;
    }

    // get number of papers
    public int getNumberOfPapers() {
        return questionPapers.size();
    }

    // retrieve a paper
    public QuestionPaper getPaper(int index) {
        if (index >= questionPapers.size()) {
            return null;
        }/////////////////////////
        else {
            return questionPapers.get(index);
        }
    }

    public QuestionPaper getPaperByPaperID(int id) {
        for (int i = 0; i < questionPapers.size(); i++) {
            if (questionPapers.get(i).getPaperID() == id) {
                return questionPapers.get(i);
            }
        }
        return null;
    }

    // add a paper to the model
    public void addPaper(QuestionPaper paper) {
        questionPapers.add(paper);


    }

    public void addPaper(int index, QuestionPaper paper) {
        questionPapers.add(index, paper);
    }

    // remove a paper from the model
    public void removePaper(int index) {
        questionPapers.remove(index);
    }

    // moves a paper up in a list
    public void movePaperUp(int index) {
        if (index <= 0) {
            return;
        }
        if (index >= questionPapers.size()) {
            return;
        }

        questionPapers.add(index - 1, getPaper(index));
        questionPapers.remove(index + 1);
    }

    // moves a paper down in a list
    public void MovePaperDown(int index) {
        movePaperUp(index + 1);
    }

    // get number of papers
    public int getNumberOfSubmission() {
        return submissions.size();
    }

    // retrieve a paper
    Submission getSubmission(int index) {
        return submissions.get(index);
    }

    // add a paper to the model
    public void addSubmission(Submission submission) {
        submissions.add(submission);

    }

    public void addSubmission(Submission submission, int index) {
        submissions.add(index, submission);
    }

    // remove a paper from the model
    public void removeSubmission(int index) {
        submissions.remove(index);
    }

    public void loadSubmissions() {
        SubmissionLoader loader = new SubmissionLoader();

        loader.loadSubmissions();

        submissions = loader.getSubmissions();
    }

    public ArrayList<Submission> getSubmissions() {

        loadSubmissions();
        return submissions;
    }

    public void removePaperByPaperID(int paperID) {
        for (int i = 0; i < questionPapers.size(); i++) {
            if (questionPapers.get(i).getPaperID() == paperID) {
                questionPapers.remove(i);
            }
        }
    }
}