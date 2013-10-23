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
public class SubmissionSubSection {

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