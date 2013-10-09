/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author mbgm8je3
 */
public class Answer {
    protected int id;
    
    public int getID() {
        return id;
    }
    
    public String toXML() {
        return "Error";
    }
}

class FITBAnswer extends Answer {
    private String answer;
    
    public FITBAnswer(int id, String answer) {
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

class MCQAnswer extends Answer {
    int answer;
    
    MCQAnswer(int id, int answer) {
        this.id = id;
        this.answer = answer;
    }
    
    public int getAnswer() {
        return answer;
    }
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<MCQAnswer>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        XML += "</MCQAnswer>\n";
        return XML;         
    }
}