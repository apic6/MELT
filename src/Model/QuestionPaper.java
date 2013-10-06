package Model;

import java.util.ArrayList;

public class QuestionPaper {

    int PaperID;
    String Title;
    String Description;
    String Instructions;
    ArrayList<Section> SectionList;
    ArrayList<Integer> EligibleStudents;
    ArrayList<Integer> EligibleSetters;

    QuestionPaper(int GivenPaperID, int CreatorID) {
        PaperID = GivenPaperID;
        SectionList = new ArrayList<>();
        EligibleStudents = new ArrayList<>();
        EligibleSetters = new ArrayList<>();
        EligibleSetters.add(CreatorID);
    }

    QuestionPaper(int GivenPaperID) {
        PaperID = GivenPaperID;
        SectionList = new ArrayList<>();
        EligibleStudents = new ArrayList<>();
        EligibleSetters = new ArrayList<>();
    }
    
    /*
     *	Modifying Question Paper
     */
    void AddEligibleStudent(int ID) {
        EligibleStudents.add(ID);
    }

    void AddEligibleStudents(int[] IDs) {
        for (int ID : IDs) {
            EligibleStudents.add(ID);
        }
    }

    void AddEligibleSetter(int ID) {
        EligibleSetters.add(ID);
    }

    void AddEligibleSetters(int[] IDs) {
        for (int ID : IDs) {
            EligibleSetters.add(ID);
        }
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

    /*
     *	Reading/Using Question Paper
     */
    int GetPaperID() {
        return PaperID;
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
    
    

    boolean IsStudentEligible(int StudentID) {
        for (int ID : EligibleStudents) {
            if (StudentID == ID) {
                return true;
            }
        }
        return false;
    }
    
    int GetNumberOfSections() {
        return SectionList.size();
    }
    
    Section GetSection(int ID) {
        return SectionList.get(ID);
    }
    
    void AddSection(int position, Section S) {
  	SectionList.add (position, S);
    }

    void RemoveSection (int position) {
        SectionList.remove(position);
    }

    void MoveSectionUp (int SectionToMove) {
        if (SectionToMove <= 0) return;
        if (SectionToMove >= SectionList.size()) return;

        SectionList.add(SectionToMove-1, GetSection(SectionToMove));
        SectionList.remove(SectionToMove +1 );
    }

    void MoveSectionDown (int SectionToMove) {
        MoveSectionUp(SectionToMove+1);
    }
    
    // produces an XML for students submission
    void CreateSubmissionDocument() {
        /* 
         * 
         */
    }
}
