package Model.questionPaper;

import java.util.ArrayList;

public class QuestionPaper {

    private int paperID;
    private String title;
    private String description;
    private String instructions;
    private ArrayList<Section> sectionList;
    private ArrayList<Integer> eligibleStudents;
    private ArrayList<Integer> eligibleSetters;

    public QuestionPaper(int GivenPaperID, int CreatorID) {
        paperID = GivenPaperID;
        sectionList = new ArrayList<>();
        eligibleStudents = new ArrayList<>();
        eligibleSetters = new ArrayList<>();
        eligibleSetters.add(CreatorID);
    }

    public QuestionPaper(int GivenPaperID) {
        paperID = GivenPaperID;
        sectionList = new ArrayList<>();
        eligibleStudents = new ArrayList<>();
        eligibleSetters = new ArrayList<>();
    }

    /*
     *	Modifying Question Paper
     */
    public void addEligibleStudent(int ID) {
        eligibleStudents.add(ID);
    }

    public void addEligibleStudents(int[] IDs) {
        for (int ID : IDs) {
            eligibleStudents.add(ID);
        }
    }

    public void addEligibleSetter(int ID) {
        eligibleSetters.add(ID);
    }

    public void addEligibleSetters(int[] IDs) {
        for (int ID : IDs) {
            eligibleSetters.add(ID);
        }
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public void setInstructions(String Instructions) {
        this.instructions = Instructions;
    }

    /*
     *	Reading/Using Question Paper
     */
    public int getPaperID() {
        return paperID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }
    
    public int getMaximumMark() {
        int maxMark = 0;
        for (int i = 0; i<sectionList.size(); i++) {
            maxMark += sectionList.get(i).getMaximumMark();
        }
        return maxMark;
    }

    public boolean isStudentEligible(int StudentID) {
        for (int ID : eligibleStudents) {
            if (StudentID == ID) {
                return true;
            }
        }
        return false;
    }

    public boolean isSetterEligible(int SetterID) {
        for (int ID : eligibleSetters) {
            if (SetterID == ID) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfSections() {
        return sectionList.size();
    }

    public Section getSection(int ID) {
        return sectionList.get(ID);
    }

    public ArrayList<Section> getSectionList() {
        return sectionList;
    }

    public void addSection(int position, Section S) {
        sectionList.add(position, S);
    }

    public void addSection(Section S) {
        sectionList.add(S);
    }

    public void removeSection(int position) {
        sectionList.remove(position);
    }

    public void moveSectionUp(int SectionToMove) {
        if (SectionToMove <= 0) {
            return;
        }
        if (SectionToMove >= sectionList.size()) {
            return;
        }

        sectionList.add(SectionToMove - 1, getSection(SectionToMove));
        sectionList.remove(SectionToMove + 1);
    }

    public void moveSectionDown(int SectionToMove) {
        moveSectionUp(SectionToMove + 1);
    }

    // produces an XML for students submission
    public void createSubmissionDocument() {
        /* 
         * 
         */
    }

    // TODO: CHANGE THIS
    public String toXML() {
        String XML = "<QuestionPaper id=\"" + paperID + "\">\n";          /////////////model.getNextID()

        XML += "<Title>" + title + "</Title>\n";
        XML += "<Description>" + description + "</Description>\n";
        XML += "<Instructions>" + instructions + "</Instructions>\n";

        // eligible students
        for (int i = 0; i < eligibleStudents.size(); i++) {
            XML += "<EligibleStudent>" + eligibleStudents.get(i) + "</EligibleStudent>\n";
        }

        // eligible teachers
        for (int i = 0; i < eligibleSetters.size(); i++) {
            XML += "<EligibleTeacher>" + eligibleSetters.get(i) + "</EligibleTeacher>\n";
        }

        // sections       
        for (int i = 0; i < sectionList.size(); i++) {
            XML += sectionList.get(i).toXML();
        }

        XML += "</QuestionPaper>\n";

        return XML;
    }
}
