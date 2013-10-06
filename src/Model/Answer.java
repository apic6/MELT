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
    int id;
    
    int getID() {
        return id;
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
}

class FITBAnswer extends Answer {
    String answer;
    
    FITBAnswer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }
    
    public String getAnswer() {
        return answer;
    }
}