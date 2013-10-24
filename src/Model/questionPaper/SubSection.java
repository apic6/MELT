/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.questionPaper;

import java.util.ArrayList;

/**
 *
 * @author Jamie
 */
public class SubSection {

    public enum CollectionType {

        QUESTIONS,
        SUBSECTIONS,
        UNDEFINED
    }
    String Title;
    String Description;
    String Instructions;
    CollectionType type = CollectionType.UNDEFINED;
    ArrayList<Question> questionList;
    ArrayList<SubSection> subSectionList;

    public SubSection() {
        questionList = null;
        subSectionList = null;
    }

    public SubSection(String Title, String Description, String Instructions) {
        questionList = null;
        subSectionList = null;
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
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

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getInstructions() {
        return Instructions;
    }

    public CollectionType getCollectionType() {
        return type;
    }

    public Question getQuestion(int ID) {
        return questionList.get(ID);
    }

    public int getNumberOfQuestions() {
        return questionList.size();
    }

    public void addQuestion(int position, Question Q) {

        questionList.add(position, Q);
    }

    public void addQuestion(Question Q) {
        questionList.add(Q);
    }

    public void removeQuestion(int position) {
        questionList.remove(position);
    }

    public void moveQuestionUp(int QuestionToMove) {
        if (QuestionToMove <= 0) {
            return;
        }
        if (QuestionToMove >= getNumberOfQuestions()) {
            return;
        }

        questionList.add(QuestionToMove - 1, getQuestion(QuestionToMove));
        questionList.remove(QuestionToMove + 1);
    }

    public void moveQuestionDown(int QuestionToMove) {
        moveQuestionUp(QuestionToMove + 1);
    }

    public SubSection getSubSection(int ID) {
        return subSectionList.get(ID);
    }

    public int getNumberOfSubSections() {
        return subSectionList.size();
    }

    public void addSubSection(int position, SubSection s) {
        subSectionList.add(position, s);
    }

    public void addSubSection(SubSection s) {
        subSectionList.add(s);
    }

    public void removeSubSection(int position) {
        subSectionList.remove(position);
    }

    public void moveSubSectionUp(int subSectionToMove) {
        if (subSectionToMove <= 0) {
            return;
        }
        if (subSectionToMove >= getNumberOfSubSections()) {
            return;
        }

        subSectionList.add(subSectionToMove - 1, getSubSection(subSectionToMove));
        subSectionList.remove(subSectionToMove + 1);
    }

    public void moveSubSectionDown(int subSectionToMove) {
        moveSubSectionUp(subSectionToMove + 1);
    }

    public String toXML() {
        String XML = "<SubSection>\n";

        XML += "<Title>" + Title + "</Title>\n";
        XML += "<Description>" + Description + "</Description>\n";
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        XML += "<CollectionType>";

        switch (type) {
            case SUBSECTIONS:
                XML += "SUBSECTIONS";
                for (int i = 0; i < subSectionList.size(); i++) {
                    XML += subSectionList.get(i).toXML();
                }                
                break;
            case QUESTIONS:
                XML += "QUESTIONS";
                for (int i = 0; i < questionList.size(); i++) {
                    XML += questionList.get(i).toXML();
                }
                break;
            case UNDEFINED:
            default:
                XML += "UNDEFINED";
                break;
        }
        XML += "</CollectionType>\n";



        XML += "</SubSection>\n";

        return XML;
    }
}
