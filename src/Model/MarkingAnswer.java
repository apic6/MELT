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
    int mark;
   
    String toXML() {
        return "Error";
    }    
    

}
class MCQMarkingAnswer extends MarkingAnswer {
    int answer;
    
    MCQMarkingAnswer(int answer, int mark) {
        this.answer = answer;
        this.mark = mark;
    }
    
    public void setAnswer(int answer) {
        this.answer = answer;
    }
    
    public void setMark(int mark) {
        this.mark = mark;
    }
    
    public int getAnswer() {
        return answer;
    }
    
    public int getMark() {
        return mark;
    }
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<MCQAnswer>\n";
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        XML += "</MCQAnswer>\n";
        return XML;         
    }        
}

class FITBMarkingAnswer extends MarkingAnswer {
    String answer;
    
    FITBMarkingAnswer(String answer, int mark) {
        this.answer = answer;
        this.mark = mark;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public void setMark(int mark) {
        this.mark = mark;
    }    
    
    public String getAnswer() {
        return answer;
    }
    
    public int getMark() {
        return mark;
    }    
    
    @Override
    public String toXML() {
        String XML = "";
        XML += "<FITBAnswer>\n";
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "<Answer>" + answer + "</Answer>\n";
        XML += "</FITBAnswer>\n";
        return XML;                
    }        
}