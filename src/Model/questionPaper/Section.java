/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.questionPaper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Jamie
 */
public class Section {

    private int timeLimit;
    private int ID;
    private String Title;
    private String Description;
    private String Instructions;
    private Timer timer;
    private int remainingTime; // in ms
    private ArrayList<SubSection> SubSectionList;
    private ActionListener timerListener;

    public Section() {
        timerListener = null;
        SubSectionList = new ArrayList<SubSection>();
    }

    public Section(int ID, String Title, String Description, String Instructions, int TimeLimit) {
        timerListener = null;
        this.ID = ID;
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
        this.timeLimit = TimeLimit;

        SubSectionList = new ArrayList<>();
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setInstructions(String Instructions) {
        this.Instructions = Instructions;
    }

    public void setTimeLimit(int TimeLimit) {
        this.timeLimit = TimeLimit;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getInstructions() {
        return Instructions;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
    
    public void setupTimer () {
        remainingTime = timeLimit * 1000;
    }

    public void startTimer(ActionListener aListener) {
        if (timerListener != null) {
            timer.removeActionListener(timerListener);
        }
        timerListener = aListener;
        timer = new Timer(1000, timerListener);
        timer.setRepeats(true);
        timer.start();
    }
    
    public void updateListener (ActionListener aListener) {
        timer.removeActionListener(timerListener);
        timerListener = aListener;
        timer = new Timer(1000, aListener);
        timer.setRepeats(true);
        timer.start();
    }
    
    public void stopTimer() {
        timer.removeActionListener(timerListener);
        timer.stop();
    }
    
    public void resumeTimer() {
        timer.start();
    }
    
    public void timerTick() {
        remainingTime -= 1000;
    }
    
    public int getRemainingTime() {
        return remainingTime;
    }
        

    public int getNumberOfSubSections() {
        return SubSectionList.size();
    }

    public SubSection getSubSection(int ID) {
        return SubSectionList.get(ID);
    }

    public ArrayList<SubSection> getSubSections() {
        return SubSectionList;
    }

    public void AddSubSection(int position, SubSection S) {
        SubSectionList.add(position, S);
    }

    public void AddSubSection(SubSection S) {
        SubSectionList.add(S);
    }

    public void RemoveSubSection(int position) {
        SubSectionList.remove(position);
    }

    public void MoveSubSectionUp(int SubSectionToMove) {
        if (SubSectionToMove <= 0) {
            return;
        }
        if (SubSectionToMove >= SubSectionList.size()) {
            return;
        }

        SubSectionList.add(SubSectionToMove - 1, getSubSection(SubSectionToMove));
        SubSectionList.remove(SubSectionToMove + 1);
    }

    public void MoveSubSectionDown(int SubSectionToMove) {
        MoveSubSectionUp(SubSectionToMove + 1);
    }

    public String toXML() {
        String XML = "<Section id=\"" + ID + "\">\n";

        XML += "<Title>" + Title + "</Title>\n";
        XML += "<Description>" + Description + "</Description>\n";
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        XML += "<TimeLimit>" + timeLimit + "</TimeLimit>\n";

        for (int i = 0; i < SubSectionList.size(); i++) {
            XML += SubSectionList.get(i).toXML();
        }

        XML += "</Section>\n";

        return XML;
    }
}
