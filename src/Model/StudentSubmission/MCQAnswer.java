/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

/**
 *
 * @author mbgm8je3
 */
public class MCQAnswer extends Answer {
    int answer;
    
    public MCQAnswer(int id, int answer) {
        this.id = id;
        this.answer = answer;
    }
    
    public int getAnswer() {
        return answer;
    }
    @Override
    public String getAnswerString(){
        
        return String.valueOf(answer);}
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<MCQAnswer>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        if (super.isMarked()) {
            XML += "<Mark>" + super.getMark() + "</Mark>";
        }
        XML += "</MCQAnswer>\n";
        return XML;         
    }
}