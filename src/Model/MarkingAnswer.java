/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author mbgm8je3
 */
public class MarkingAnswer {
    int id;
    int mark;
    
    int getID() {
        return id;
    }
}
class MCQMarkingAnswer extends MarkingAnswer {
    int answer;
    
    MCQMarkingAnswer(int answer, int mark) {
        this.answer = answer;
        this.mark = mark;
    }
    
    void setAnswer(int answer) {
        this.answer = answer;
    }
    
    void setMark(int mark) {
        this.mark = mark;
    }
    
    int getAnswer() {
        return answer;
    }
    
    int getMark() {
        return mark;
    }
}

class FITBMarkingAnswer extends MarkingAnswer {
    String answer;
    
    FITBMarkingAnswer(String answer, int mark) {
        this.answer = answer;
        this.mark = mark;
    }
    
    void setAnswer(String answer) {
        this.answer = answer;
    }
    
    void setMark(int mark) {
        this.mark = mark;
    }    
    
    String getAnswer() {
        return answer;
    }
    
    int getMark() {
        return mark;
    }    
}