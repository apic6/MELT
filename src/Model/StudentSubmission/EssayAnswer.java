/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

/**
 *
 * @author mbgm8je3
 */
public class EssayAnswer extends Answer {

    int sectionID;
    int subSectionID;
    String answer;

    public EssayAnswer(int sectionID, int subSectionID, int questionID, String answer) {
        this.marked = false;
        this.id = questionID;
        this.sectionID = sectionID;
        this.subSectionID = subSectionID;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
    @Override
    public String getAnswerString(){return answer;}
    
    public int getSectionID () {
        return sectionID;
    }
    
    public int getSubSectionID () {
        return subSectionID;
    }    

    @Override
    public String toXML() {
        String XML = "";
        XML += "<EssayAnswer>\n";
        XML += "<SectionID>" + sectionID + "</SectionID>\n";
        XML += "<SubSectionID>" + subSectionID + "</SubSectionID>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        XML += "</EssayAnswer>\n";
        return XML;
    }
}