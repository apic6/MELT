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
    CollectionType type;
    ArrayList<Question> questionList;
    ArrayList<SubSection> subSectionList;

    public SubSection() {
        questionList = null;
        subSectionList = null;
        type = CollectionType.QUESTIONS;
        questionList = new ArrayList<Question>();
    }

    public SubSection(String Title, String Description, String Instructions) {
        questionList = null;
        subSectionList = null;
        type = CollectionType.UNDEFINED;
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
        questionList = new ArrayList<Question>();
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
        if (type == CollectionType.QUESTIONS) {
            return questionList.get(ID);
        } else {
            return null;
        }

    }

    public int getNumberOfQuestions() {
        if (type == CollectionType.QUESTIONS) {
            return questionList.size();
        } else {
            return -1;
        }

    }

    public boolean addQuestion(int position, Question Q) {
        if (type == CollectionType.UNDEFINED) {
            type = CollectionType.QUESTIONS;
            questionList = new ArrayList<>();
            questionList.add(position, Q);
            return true;
        } else if (type == CollectionType.QUESTIONS) {
            questionList.add(position, Q);
            return true;
        } else {
            return false;
        }
    }

    public boolean addQuestion(Question Q) {
        if (type == CollectionType.UNDEFINED) {
            type = CollectionType.QUESTIONS;
            questionList = new ArrayList<>();
            questionList.add(Q);
            return true;
        } else if (type == CollectionType.QUESTIONS) {
            questionList.add(Q);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeQuestion(int position) {
        if (type == CollectionType.QUESTIONS) {
            questionList.remove(position);
            return true;
        } else {
            return false;
        }

    }

    public boolean moveQuestionUp(int QuestionToMove) {
        if (type == CollectionType.QUESTIONS) {
            if (QuestionToMove <= 0) {
                return false;
            }
            if (QuestionToMove >= getNumberOfQuestions()) {
                return false;
            }

            questionList.add(QuestionToMove - 1, getQuestion(QuestionToMove));
            questionList.remove(QuestionToMove + 1);
            return true;
        } else {
            return false;
        }

    }

    public void moveQuestionDown(int QuestionToMove) {
        moveQuestionUp(QuestionToMove + 1);
    }

    public SubSection getSubSection(int ID) {
        if (type == CollectionType.SUBSECTIONS) {
            return subSectionList.get(ID);
        } else {
            return null;
        }
    }

    public int getNumberOfSubSections() {
        if (type == CollectionType.SUBSECTIONS) {
            return subSectionList.size();
        } else {
            return -1;
        }
    }

    public boolean addSubSection(int position, SubSection s) {
        if (type == CollectionType.UNDEFINED) {
            type = CollectionType.SUBSECTIONS;
            subSectionList = new ArrayList<>();
            subSectionList.add(position, s);
            return true;
        } else if (type == CollectionType.SUBSECTIONS) {
            subSectionList.add(position, s);
            return true;
        } else {
            return false;
        }
    }

    public boolean addSubSection(SubSection s) {
        if (type == CollectionType.UNDEFINED) {
            type = CollectionType.SUBSECTIONS;
            subSectionList = new ArrayList<>();
            subSectionList.add(s);
            return true;
        } else if (type == CollectionType.SUBSECTIONS) {
            subSectionList.add(s);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeSubSection(int position) {

        if (type == CollectionType.SUBSECTIONS) {
            subSectionList.remove(position);
            return true;
        } else {
            return false;
        }

    }

    public boolean moveSubSectionUp(int subSectionToMove) {
        if (type == CollectionType.SUBSECTIONS) {
            if (subSectionToMove <= 0) {
                return false;
            }
            if (subSectionToMove >= getNumberOfSubSections()) {
                return false;
            }

            subSectionList.add(subSectionToMove - 1, getSubSection(subSectionToMove));
            subSectionList.remove(subSectionToMove + 1);
            return true;
        } else {
            return false;
        }
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
                XML += "</CollectionType>\n";
                for (int i = 0; i < subSectionList.size(); i++) {
                    XML += subSectionList.get(i).toXML();
                }
                break;
            case QUESTIONS:
                XML += "QUESTIONS";
                XML += "</CollectionType>\n";
                for (int i = 0; i < questionList.size(); i++) {
                    XML += questionList.get(i).toXML();
                }
                break;
            case UNDEFINED:
            default:
                XML += "UNDEFINED</CollectionType>\n";
                break;
        }
        



        XML += "</SubSection>\n";

        return XML;
    }
}
