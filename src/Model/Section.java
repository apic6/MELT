/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
    public void SetTitle ( String Title) {
        this.Title = Title;
    }
    
    public void SetDescription ( String Description) {
        this.Description = Description;
    }
    
    public void SetInstructions ( String Instructions ) {
        this.Instructions = Instructions;
    }
    
    public void SetTimeLimit ( int TimeLimit) {
        this.TimeLimit = TimeLimit;
    }
    
    public int GetID(){
        return ID;
    }
    
    public String GetTitle(){
        return Title;
    }
    
    public String GetDescription(){
        return Description;
    }
    
    public String GetInstructions() {
        return Instructions;
    }
    
    public int GetTimeLimit(){
        return TimeLimit;
    }
    
    public int GetNumberOfSubSections() {
        return SubSectionList.size();
    }
    
    public SubSection GetSubSection(int ID) {
        return SubSectionList.get(ID);
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

        SubSectionList.add(SubSectionToMove-1, GetSubSection(SubSectionToMove));
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
