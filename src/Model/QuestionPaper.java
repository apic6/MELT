package Model;

import java.util.ArrayList;

public class QuestionPaper {

    private int PaperID;
    private String Title;
    private String Description;
    private String Instructions;
    private ArrayList<Section> SectionList;
    private ArrayList<Integer> EligibleStudents;
    private ArrayList<Integer> EliglbeTeachers;

    public QuestionPaper(int GivenPaperID, int CreatorID) {
        PaperID = GivenPaperID;
        SectionList = new ArrayList<>();
        EligibleStudents = new ArrayList<>();
        EliglbeTeachers = new ArrayList<>();
        EliglbeTeachers.add(CreatorID);
    }

    public QuestionPaper(int GivenPaperID) {
        PaperID = GivenPaperID;
        SectionList = new ArrayList<>();
        EligibleStudents = new ArrayList<>();
        EliglbeTeachers = new ArrayList<>();
    }
    
    /*
     *	Modifying Question Paper
     */
    public void addEligibleStudent(int ID) {
        EligibleStudents.add(ID);
    }

    public void addEligibleStudents(int[] IDs) {
        for (int ID : IDs) {
            EligibleStudents.add(ID);
        }
    }

    public void addEligibleSetter(int ID) {
        EliglbeTeachers.add(ID);
    }

    public void addEligibleSetters(int[] IDs) {
        for (int ID : IDs) {
            EliglbeTeachers.add(ID);
        }
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

    /*
     *	Reading/Using Question Paper
     */
    public int getPaperID() {
        return PaperID;
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
    
    

    public boolean isStudentEligible(int StudentID) {
        for (int ID : EligibleStudents) {
            if (StudentID == ID) {
                return true;
            }
        }
        return false;
    }
    
    public int getNumberOfSections() {
        return SectionList.size();
    }
    
    public Section getSection(int ID) {
        return SectionList.get(ID);
    }
    
    public ArrayList<Section> getSectionList(){
        return SectionList;
    }
    
    public void addSection(int position, Section S) {
  	SectionList.add (position, S);
    }
    
    public void addSection(Section S) {
  	SectionList.add (S);
    }

    public void removeSection (int position) {
        SectionList.remove(position);
    }

    public void moveSectionUp (int SectionToMove) {
        if (SectionToMove <= 0) return;
        if (SectionToMove >= SectionList.size()) return;

        SectionList.add(SectionToMove-1, getSection(SectionToMove));
        SectionList.remove(SectionToMove +1 );
    }

    public void moveSectionDown (int SectionToMove) {
        moveSectionUp(SectionToMove+1);
    }
    
    // produces an XML for students submission
    public void createSubmissionDocument() {
        /* 
         * 
         */
    }
    
    public String toXML(Modeller model) {
        String XML = "<QuestionPaper id=\"" + model.getNextID() + "\">\n";
        
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
