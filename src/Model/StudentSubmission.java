/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mbgm8je3
 */
class SubmissionSubSection {

    int subSectionID;
    ArrayList<Answer> answerList;

    public SubmissionSubSection(int id) {
        this.subSectionID = id;
        answerList = new ArrayList<>();
    }

    public int getID() {
        return subSectionID;
    }

    public void addAnswer(Answer answer) {
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).getID() == answer.getID()) {
                answerList.remove(i);
                answerList.add(answer);
                return;
            }
        }
        answerList.add(answer);
    }

    public int getSize() {
        return answerList.size();
    }

    public Answer getAnswer(int id) {
        return answerList.get(id);
    }

    public void normalise() {
        Collections.sort(answerList, new Comparator<Answer>() {
            public int compare(Answer a, Answer b) {
                return a.getID() - b.getID();
            }
        });
    }

    public String toXML() {
        String XML = "";
        XML += "<SubmissionSubSection>\n";
        XML += "<SubSectionID>" + subSectionID + "</SubSectionID>\n";
        for (int i = 0; i < answerList.size(); i++) {
            XML += answerList.get(i).toXML() + "\n";
        }
        XML += "</SubmissionSubSection>\n";
        return XML;
    }
}

class SubmissionSection {

    int sectionID;
    ArrayList<SubmissionSubSection> subSectionList;

    public SubmissionSection(int id) {
        this.sectionID = id;
        subSectionList = new ArrayList<>();
    }

    public int getID() {
        return sectionID;
    }

    public void addSubSection(SubmissionSubSection subSection) {
        subSectionList.add(subSection);
    }

    public int getSize() {
        return subSectionList.size();
    }

    public SubmissionSubSection getSubSection(int id) {
        return subSectionList.get(id);
    }

    public void normalise() {
        Collections.sort(subSectionList, new Comparator<SubmissionSubSection>() {
            public int compare(SubmissionSubSection a, SubmissionSubSection b) {
                return a.getID() - b.getID();
            }
        });
        for (int i = 0; i < subSectionList.size(); i++) {
            subSectionList.get(i).normalise();
        }
    }

    public String toXML() {
        String XML = "";
        XML += "<SubmissionSection>\n";
        XML += "<SectionID>" + sectionID + "</SectionID>\n";
        for (int i = 0; i < subSectionList.size(); i++) {
            XML += subSectionList.get(i).toXML() + "\n";
        }
        XML += "</SubmissionSection>\n";
        return XML;
    }
}

public class StudentSubmission {

    int paperID;
    int studentID;
    ArrayList<SubmissionSection> sectionList;

    public StudentSubmission(int paperID, int studentID) {
        this.paperID = paperID;
        this.studentID = studentID;
        sectionList = new ArrayList<>();
    }

    public int getPaperID() {
        return paperID;
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
        XML += "<StudentSubmission id=\"" + paperID + "\">\n";
        XML += "<StudentID>" + studentID + "</StudentID>\n";
        for (int i = 0; i < sectionList.size(); i++) {
            XML += sectionList.get(i).toXML() + "\n";
        }
        XML += "</StudentSubmission>\n";
        return XML;
    }
}
