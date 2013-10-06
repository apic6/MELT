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

    int TimeLimit;
    int ID;
    String Title;
    String Description;
    String Instructions;

    ArrayList<SubSection> SubSectionList;
    
    
    Section (int ID, String Title, String Description, String Instructions, int TimeLimit) {
        this.ID = ID;
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
        this.TimeLimit = TimeLimit;
        
        SubSectionList = new ArrayList<>();
    }
    
    void SetTitle ( String Title) {
        this.Title = Title;
    }
    
    void SetDescription ( String Description) {
        this.Description = Description;
    }
    
    void SetInstructions ( String Instructions ) {
        this.Instructions = Instructions;
    }
    
    void SetTimeLimit ( int TimeLimit) {
        this.TimeLimit = TimeLimit;
    }
    
    int GetID(){
        return ID;
    }
    
    String GetTitle(){
        return Title;
    }
    
    String GetDescription(){
        return Description;
    }
    
    String GetInstructions() {
        return Instructions;
    }
    
    int GetTimeLimit(){
        return TimeLimit;
    }
    
    int GetNumberOfSubSections() {
        return SubSectionList.size();
    }
    
    SubSection GetSubSection(int ID) {
        return SubSectionList.get(ID);
    }
    
    void AddSubSection(int position, SubSection S) {
  	SubSectionList.add (position, S);
    }

    void RemoveSubSection (int position) {
        SubSectionList.remove(position);
    }

    void MoveSubSectionUp (int SubSectionToMove) {
        if (SubSectionToMove <= 0) return;
        if (SubSectionToMove >= SubSectionList.size()) return;

        SubSectionList.add(SubSectionToMove-1, GetSubSection(SubSectionToMove));
        SubSectionList.remove(SubSectionToMove +1 );
    }

    void MoveSubSectionDown (int SubSectionToMove) {
        MoveSubSectionUp(SubSectionToMove+1);
    }
    
    String toXML() {
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
