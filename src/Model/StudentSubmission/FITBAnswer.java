/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

/**
 *
 * @author mbgm8je3
 */
public class FITBAnswer extends Answer {
    private String answer;
    
    public FITBAnswer(int id, String answer) {
        this.marked = false;
        this.id = id;
        this.answer = answer;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<FITBAnswer>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        XML += "</FITBAnswer>\n";
        return XML;                
    }    
}
