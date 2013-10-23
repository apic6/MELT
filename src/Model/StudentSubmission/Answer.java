/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;


/**
 *
 * @author mbgm8je3
 */
public class Answer {
    protected int id;
    boolean marked;
    
    public int getQuestionID() {
        return id;
    }
    
    public boolean isMarked() {
        return marked;
    }
    
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
    
    public String toXML() {
        return "Error";
    }
}



