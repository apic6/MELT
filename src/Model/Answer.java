/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;


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

class MFITBAnswer extends Answer {
    ArrayList<String> answers;
    
    MFITBAnswer(int id, ArrayList<String> answers) {
        this.id = id;
        answers = new ArrayList<>();
        for (int i = 0; i<answers.size(); i++)
            this.answers.add(answers.get(i));
    }
    
    public int getNumberOfAnswers() {
        return answers.size();
    }
    
    public String getAnswer(int i) {
        return answers.get(i);
    }
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<MFITBAnswer>\n";
        XML += "<AnswerID>" + id + "</AnswerID>\n";
        for (int i = 0; i<answers.size(); i++)
            XML += "<Answer>" + answers.get(i) + "</Answer>\n";
        XML += "</MFITBAnswer>\n";
        return XML;         
    }
}

class EssayAnswer extends Answer {
    String answer;
    
    EssayAnswer(int id, String answer) {
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