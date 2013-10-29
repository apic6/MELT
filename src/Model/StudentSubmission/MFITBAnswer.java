/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

import java.util.ArrayList;

/**
 *
 * @author mbgm8je3
 */
public class MFITBAnswer extends Answer {

    int sectionID;
    int subSectionID;
    ArrayList<String> answers;
    ArrayList<Integer> subSectionIDs;

    public MFITBAnswer(int sectionID, int subSectionID, int questionID, ArrayList<String> answers) {
        this.marked = false;
        this.id = questionID;
        this.sectionID = sectionID;
        this.subSectionID = subSectionID;
        if (answers == null) {
            answers = new ArrayList<String>();
        }
        this.answers = answers;
    }

    public MFITBAnswer(int sectionID, ArrayList<Integer> subSectionIDs, int questionID, ArrayList<String> answers) {
        this.marked = false;
        this.id = questionID;
        this.sectionID = sectionID;
        this.subSectionIDs = subSectionIDs;
        if (answers == null) {
            answers = new ArrayList<>();
        }
        this.answers = answers;
    }

    public int getNumberOfAnswers() {
        return answers.size();
    }

    public String getAnswer(int i) {
        return answers.get(i);
    }

    @Override
    public String getAnswerString() {
        if (answer == null) {
            for (int i = 0; i < answers.size(); i++) {

                answer = answer + " " + answers.get(i);
            }
        }
        return answer;
    }

    public int getSectionID() {
        return sectionID;
    }

    public int getSubSectionID() {
        return subSectionID;
    }

    public int getSizeOfSubSectionList() {
        return subSectionIDs.size();
    }

    public int getSubSectionAtIndex(int i) {
        return subSectionIDs.get(i);
    }

    @Override
    public String toXML() {
        String XML = "";
        XML += "<MFITBAnswer>\n";
        XML += "<SectionID>" + sectionID + "</SectionID>\n";
        XML += "<SubSectionID>" + subSectionID + "</SubSectionID>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        for (int i = 0; i < answers.size(); i++) {
            XML += "<Answer>" + answers.get(i) + "</Answer>\n";
        }
//        XML += "<Marked>";
//        if (super.isMarked()) {
//            XML += "TRUE";
//        } else {
//            XML += "FALSE";
//        }
//        XML += "</Marked>";
        if (marked) {
            XML += "<Marked>TRUE</Marked>";
            XML += "<Mark>" + mark+ "</Mark>";
        } else {
            XML += "<Marked>FALSE</Marked>";
        }
        XML += "</MFITBAnswer>\n";
        return XML;
    }
}