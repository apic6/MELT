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
    protected boolean marked;
    private int mark;
    
    public int getID() {
        return id;
    }
    
    public boolean isMarked() {
        return marked;
    }
    
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
    
    public int getMark() {
        return mark;
    }
    
    public void setMark(int mark) {
        this.mark = mark;
    }
    
    public String toXML() {
        return "Error";
    }
}


