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
    
    public int getAnswer() {
        return answer;
    }
}

class FITBAnswer extends Answer {
    String answer;
    
    public String getAnswer() {
        return answer;
    }
}