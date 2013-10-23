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
    String answer;
    
    public EssayAnswer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<EssayAnswer>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        XML += "</EssayAnswer>\n";
        return XML;         
    }
}