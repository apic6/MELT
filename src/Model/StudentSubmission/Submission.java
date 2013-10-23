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
    ArrayList<SubmissionSection> sectionList;

    public Submission(int paperID, int studentID) {
        this.paperID = paperID;
        this.studentID = studentID;
        sectionList = new ArrayList<>();
    }
    
    public Submission(int submissionID, int paperID, int studentID) {
        this.paperID = paperID;
        this.studentID = studentID;
    }

    public int getPaperID() {
        return paperID;
    }
    public int getStudentID(){
    return studentID;}

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
            public int compare(SubmissionSection a, SubmissionSection b) {
                return a.getID() - b.getID();
            }
        });

        for (int i = 0; i < sectionList.size(); i++) {
            sectionList.get(i).normalise();
        }
    }

    public String toXML() {
        String XML = "";
        XML += "<StudentSubmission id=\"" + paperID + studentID + "\">\n";
        XML += "<PaperID>" + paperID + "</PaperID>\n";
        XML += "<StudentID>" + studentID + "</StudentID>\n";
        for (int i = 0; i < sectionList.size(); i++) {
            XML += sectionList.get(i).toXML() + "\n";
        }
        XML += "</StudentSubmission>\n";
        return XML;
    }
}
