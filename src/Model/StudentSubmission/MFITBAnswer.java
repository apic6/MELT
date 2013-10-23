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
    ArrayList<String> answers;
    
    public MFITBAnswer(int id, ArrayList<String> answers) {
        this.id = id;
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