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
    boolean fullyMarked;
    ArrayList<Answer> answerList;

    public SubmissionSubSection(int id) {
        this.subSectionID = id;
        fullyMarked = false;
        answerList = new ArrayList<>();
    }

    public int getID() {
        return subSectionID;
    }

    public boolean isFullyMarked() {
        return fullyMarked;
    }

    public void addAnswer(Answer answer) {
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).getQuestionID() == answer.getQuestionID()) {
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
                return a.getQuestionID() - b.getQuestionID();
            }
        });
        fullyMarked = true;
        for (int i = 0; i < answerList.size(); i++) {
            fullyMarked = true;
            if (!answerList.get(i).isMarked()) {
                fullyMarked = false;
            }
        }
    }

    public ArrayList<Answer> getUnmarkedQuestions() {
        ArrayList<Answer> answers = new ArrayList<>();
        for (int i = 0; i < answerList.size(); i++) {
            if (!answerList.get(i).isMarked())
                answers.add(answerList.get(i));
        }
        return answers;
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