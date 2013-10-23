/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.questionPaper;

import 	java.util.ArrayList;

/**
 *
 * @author Jamie
 */
public class Section {

    private int TimeLimit;
    private int ID;
    private String Title;
    private String Description;
    private String Instructions;

    private ArrayList<SubSection> SubSectionList;
    
    public Section(){
        SubSectionList = new ArrayList();
    }
    
    public Section (int ID, String Title, String Description, String Instructions, int TimeLimit) {
        this.ID = ID;
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
        this.TimeLimit = TimeLimit;
        
        SubSectionList = new ArrayList<>();
    }
    
    public void setTitle ( String Title) {
        this.Title = Title;
    }
    
    public void setDescription ( String Description) {
        this.Description = Description;
    }
    
    public void setInstructions ( String Instructions ) {
        this.Instructions = Instructions;
    }
    
    public void setTimeLimit ( int TimeLimit) {
        this.TimeLimit = TimeLimit;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public String getInstructions() {
        return Instructions;
    }
    
    public int getTimeLimit(){
        return TimeLimit;
    }
    
    public int getNumberOfSubSections() {
        return SubSectionList.size();
    }
    
    public SubSection getSubSection(int ID) {
        return SubSectionList.get(ID);
    }
    
    public ArrayList<SubSection> getSubSections(){
        return SubSectionList;
    }
    
    public void AddSubSection(int position, SubSection S) {
  	SubSectionList.add (position, S);
    }
    
    public void AddSubSection(SubSection S) {
  	SubSectionList.add (S);
    }

    public void RemoveSubSection (int position) {
        SubSectionList.remove(position);
    }

    public void MoveSubSectionUp (int SubSectionToMove) {
        if (SubSectionToMove <= 0) return;
        if (SubSectionToMove >= SubSectionList.size()) return;

        SubSectionList.add(SubSectionToMove-1, getSubSection(SubSectionToMove));
        SubSectionList.remove(SubSectionToMove +1 );
    }

    public void MoveSubSectionDown (int SubSectionToMove) {
        MoveSubSectionUp(SubSectionToMove+1);
    }
    
    public String toXML() {
        String XML = "<Section id=\"" + ID + "\">\n";
        
        XML += "<Title>" + Title + "</Title>\n";
        XML += "<Description>" + Description + "</Description>\n";
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        XML += "<TimeLimit>" + TimeLimit + "</TimeLimit>\n";
        
        for (int i = 0; i<SubSectionList.size(); i++) {
            XML += SubSectionList.get(i).toXML();
        }
        
        XML += "</Section>\n";
        
        return XML;
    }    
}
