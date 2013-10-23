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
    
    public MFITBAnswer(int sectionID, int subSectionID, int questionID, ArrayList<String> answers) {
        this.marked = false;
        this.id = questionID;
        this.sectionID = sectionID;
        this.subSectionID = subSectionID;
        this.answers = new ArrayList<>();
        for (int i = 0; i<answers.size(); i++)
            this.answers.add(answers.get(i));
    }
    
    public int getNumberOfAnswers() {
        return answers.size();
    }
    
    public String getAnswer(int i) {
        return answers.get(i);
    }
    
    public int getSectionID () {
        return sectionID;
    }
    
    public int getSubSectionID () {
        return subSectionID;
    }    
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<MFITBAnswer>\n";
        XML += "<SectionID>" + sectionID + "</SectionID>\n";
        XML += "<SubSectionID>" + subSectionID + "</SubSectionID>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        for (int i = 0; i<answers.size(); i++)
            XML += "<Answer>" + answers.get(i) + "</Answer>\n";
        XML += "</MFITBAnswer>\n";
        return XML;         
    }
}