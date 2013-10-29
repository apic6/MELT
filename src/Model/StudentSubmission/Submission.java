/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mbgm8je3
 */
public class Submission {

    int paperID;
    int studentID;
    int mark;
    int totalMark;
    boolean fullyMarked;
    boolean submitted;
    ArrayList<SubmissionSection> sectionList;

    public Submission(int paperID, int studentID) {
        this.paperID = paperID;
        this.studentID = studentID;
        mark = 0;
        totalMark = 0;
        fullyMarked = false;
        submitted = false;
        sectionList = new ArrayList<>();
    }

    public Submission(int submissionID, int paperID, int studentID) {
        this.paperID = paperID;
        this.studentID = studentID;
    }

    public int getPaperID() {
        return paperID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getMark() {
        return mark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setMark(int mark, int totalMark) {
        this.mark = mark;
        this.totalMark = totalMark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setFullyMarked(boolean marked) {
        // System.err.println("Fully marked" + this.studentID + this.paperID);
        fullyMarked = marked;
    }

    public boolean isFullyMarked() {
        return fullyMarked;
    }

    public void setSubmitted() {
        submitted = true;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void addSection(SubmissionSection section) {
        sectionList.add(section);
    }

    public int getSize() {
        return sectionList.size();
    }

    public SubmissionSection getSection(int id) {
        return sectionList.get(id);
    }

    public void normalise() {
        Collections.sort(sectionList, new Comparator<SubmissionSection>() {
            @Override
            public int compare(SubmissionSection a, SubmissionSection b) {
                return a.getID() - b.getID();
            }
        });

        for (int i = 0; i < sectionList.size(); i++) {
            sectionList.get(i).normalise();
            this.fullyMarked = true;
            if (!sectionList.get(i).isFullyMarked()) {
                this.fullyMarked = false;
            }
        }
    }

    public ArrayList<Answer> getUnmarkedQuestions() {
        ArrayList<Answer> answers = new ArrayList<>();
        for (int i = 0; i < sectionList.size(); i++) {
            answers.addAll(sectionList.get(i).getUnmarkedQuestions());
        }
        return answers;
    }

    public ArrayList<Answer> getMarkableAnswers() {
        ArrayList<Answer> answers = new ArrayList<>();
        for (int i = 0; i < sectionList.size(); i++) {
            answers.addAll(sectionList.get(i).getMarkableAnswers());
        }
        return answers;
    }

    public String toXML() {
        String XML = "";
        XML += "<StudentSubmission id=\"" + paperID + studentID + "\">\n";
        XML += "<PaperID>" + paperID + "</PaperID>\n";
        XML += "<StudentID>" + studentID + "</StudentID>\n";
        XML += "<FullyMarked>";
        if (fullyMarked) {
            XML += "TRUE";
        } else {
            XML += "FALSE";
        }
        XML += "</FullyMarked>";
        XML += "<Mark>" + mark + "</Mark>";
        XML += "<TotalMark>" + mark + "</TotalMark>";
        for (int i = 0; i < sectionList.size(); i++) {
            XML += sectionList.get(i).toXML() + "\n";
        }
        XML += "</StudentSubmission>\n";
        return XML;
    }
}
