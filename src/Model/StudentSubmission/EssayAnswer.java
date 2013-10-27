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
public class EssayAnswer extends Answer {

    int sectionID;
    int subSectionID;
    String answer;
    ArrayList<Integer> subSectionIDs;

    public EssayAnswer(int sectionID, int subSectionID, int questionID, String answer) {
        this.marked = false;
        this.id = questionID;
        this.sectionID = sectionID;
        this.subSectionID = subSectionID;
        this.answer = answer;
    }

    public EssayAnswer(int sectionID, ArrayList<Integer> subSectionIDs, int questionID, String answer) {
        this.marked = false;
        this.id = questionID;
        this.sectionID = sectionID;
        this.subSectionIDs = subSectionIDs;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String getAnswerString() {
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
        XML += "<EssayAnswer>\n";
        XML += "<SectionID>" + sectionID + "</SectionID>\n";
        XML += "<SubSectionID>" + subSectionID + "</SubSectionID>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        if (super.isMarked()) {
            XML += "<Mark>" + super.getMark() + "</Mark>";
        }
        XML += "</EssayAnswer>\n";
        return XML;
    }
}