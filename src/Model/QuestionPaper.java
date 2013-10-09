package Model;

import java.util.ArrayList;

public class QuestionPaper {

    private int PaperID;
    private String Title;
    private String Description;
    private String Instructions;
    ArrayList<Section> SectionList;
    ArrayList<Integer> EligibleStudents;
    ArrayList<Integer> EliglbeTeachers;

    QuestionPaper(int GivenPaperID, int CreatorID) {
        PaperID = GivenPaperID;
        SectionList = new ArrayList<>();
        EligibleStudents = new ArrayList<>();
        EliglbeTeachers = new ArrayList<>();
        EliglbeTeachers.add(CreatorID);
    }

    QuestionPaper(int GivenPaperID) {
        PaperID = GivenPaperID;
        SectionList = new ArrayList<>();
        EligibleStudents = new ArrayList<>();
        EliglbeTeachers = new ArrayList<>();
    }
    
    /*
     *	Modifying Question Paper
     */
    public void AddEligibleStudent(int ID) {
        EligibleStudents.add(ID);
    }

    public void AddEligibleStudents(int[] IDs) {
        for (int ID : IDs) {
            EligibleStudents.add(ID);
        }
    }

    public void AddEligibleSetter(int ID) {
        EliglbeTeachers.add(ID);
    }

    public void AddEligibleSetters(int[] IDs) {
        for (int ID : IDs) {
            EliglbeTeachers.add(ID);
        }
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

    /*
     *	Reading/Using Question Paper
     */
    public int GetPaperID() {
        return PaperID;
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
    
    

    public boolean IsStudentEligible(int StudentID) {
        for (int ID : EligibleStudents) {
            if (StudentID == ID) {
                return true;
            }
        }
        return false;
    }
    
    public int GetNumberOfSections() {
        return SectionList.size();
    }
    
    public Section GetSection(int ID) {
        return SectionList.get(ID);
    }
    
    public void AddSection(int position, Section S) {
  	SectionList.add (position, S);
    }

    public void RemoveSection (int position) {
        SectionList.remove(position);
    }

    public void MoveSectionUp (int SectionToMove) {
        if (SectionToMove <= 0) return;
        if (SectionToMove >= SectionList.size()) return;

        SectionList.add(SectionToMove-1, GetSection(SectionToMove));
        SectionList.remove(SectionToMove +1 );
    }

    public void MoveSectionDown (int SectionToMove) {
        MoveSectionUp(SectionToMove+1);
    }
    
    // produces an XML for students submission
    public void CreateSubmissionDocument() {
        /* 
         * 
         */
    }
    
    public String toXML() {
        String XML = "<QuestionPaper id=\"" + PaperID + "\">\n";
        
        XML += "<Title>" + Title + "</Title>\n";
        XML += "<Description>" + Description + "</Description>\n";
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        
        // eligible students
        for (int i = 0; i<EligibleStudents.size(); i++) {
            XML += "<EligibleStudent>" + EligibleStudents.get(i) + "</EligibleStudent>\n";
        }
        
        // eligible teachers
        for (int i = 0; i<EliglbeTeachers.size(); i++) {
            XML += "<EligibleTeacher>" + EliglbeTeachers.get(i) + "</EligibleTeacher>\n";
        }
        
        // sections       
        for (int i = 0; i<SectionList.size(); i++) {
            XML += SectionList.get(i).toXML();
        }
        
        XML += "</QuestionPaper>\n";
        
        return XML;
    }       
    
}
