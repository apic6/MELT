/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

import static Model.questionPaper.SubSection.CollectionType.QUESTIONS;
import static Model.questionPaper.SubSection.CollectionType.SUBSECTIONS;
import static Model.questionPaper.SubSection.CollectionType.UNDEFINED;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mbgm8je3
 */
public class SubmissionSubSection {

    public enum CollectionType {

        ANSWERS,
        SUBSECTIONS,
        UNDEFINED
    };
    int subSectionID;
    boolean fullyMarked;
    ArrayList<Answer> answerList;
    ArrayList<SubmissionSubSection> subsectionList;
    CollectionType type;

    public SubmissionSubSection(int id) {
        type = CollectionType.UNDEFINED;
        this.subSectionID = id;
        fullyMarked = false;
        answerList = new ArrayList<>();
        subsectionList = new ArrayList<>();
    }

    public int getID() {
        return subSectionID;
    }

    public boolean isFullyMarked() {
        return fullyMarked;
    }

    public void addAnswer(Answer answer) {
        if (type == CollectionType.UNDEFINED) {
            type = CollectionType.ANSWERS;
            for (int i = 0; i < answerList.size(); i++) {
                if (answerList.get(i).getID() == answer.getID()) {
                    answerList.remove(i);
                    answerList.add(answer);
                    return;
                }
            }
            answerList.add(answer);
        } else if (type == CollectionType.ANSWERS) {
            for (int i = 0; i < answerList.size(); i++) {
                if (answerList.get(i).getID() == answer.getID()) {
                    answerList.remove(i);
                    answerList.add(answer);
                    return;
                }
            }
            answerList.add(answer);
        }

    }

    public void addSubSection(SubmissionSubSection subSection) {
        if (type == CollectionType.UNDEFINED) {
            type = CollectionType.SUBSECTIONS;
            subsectionList.add(subSection);
        } else if (type == CollectionType.SUBSECTIONS) {
            subsectionList.add(subSection);
        }

    }

    public int getSize() {
        if (type == CollectionType.ANSWERS) {
            return answerList.size();
        } else if (type == CollectionType.SUBSECTIONS) {
            return subsectionList.size();
        } else {
            return 0;
        }
    }

    public CollectionType getType() {
        return type;
    }

    public Answer getAnswer(int id) {
        return answerList.get(id);
    }

    public SubmissionSubSection getSubSection(int id) {
        return subsectionList.get(id);
    }

    public void normalise() {
        if (type == CollectionType.ANSWERS) {
            Collections.sort(answerList, new Comparator<Answer>() {
                public int compare(Answer a, Answer b) {
                    return a.getID() - b.getID();
                }
            });
            fullyMarked = true;
            for (int i = 0; i < answerList.size(); i++) {
                fullyMarked = true;
                if (!answerList.get(i).isMarked()) {
                    fullyMarked = false;
                }
            }
        } else if (type == CollectionType.SUBSECTIONS) {
            for (int i = 0; i < subsectionList.size(); i++) {
                subsectionList.get(i).normalise();
            }
        }
    }

    public ArrayList<Answer> getUnmarkedQuestions() {
        ArrayList<Answer> answers = new ArrayList<>();
        if (type == CollectionType.ANSWERS) {
            for (int i = 0; i < answerList.size(); i++) {
                if (!answerList.get(i).isMarked()) {
                    answers.add(answerList.get(i));
                }
            }
        } else if (type == CollectionType.SUBSECTIONS) {
            for (int i = 0; i < subsectionList.size(); i++) {
                answers.addAll(subsectionList.get(i).getUnmarkedQuestions());
            }
        }
        return answers;
    }

    public ArrayList<Answer> getMarkableAnswers() {
        ArrayList<Answer> answers = new ArrayList<>();
        if (type == CollectionType.ANSWERS) {
            for (int i = 0; i < answerList.size(); i++) {
                if (answerList.get(i) instanceof EssayAnswer) {
                    answers.add(answerList.get(i));
                } else if (answerList.get(i) instanceof MFITBAnswer) {
                    answers.add(answerList.get(i));
                }
            }
        } else if (type == CollectionType.SUBSECTIONS) {
            for (int i = 0; i < subsectionList.size(); i++) {
                answers.addAll(subsectionList.get(i).getMarkableAnswers());
            }
        }
        return answers;
    }

    public String toXML() {
        String XML = "";
        XML += "<SubmissionSubSection>\n";
        XML += "<SubSectionID>" + subSectionID + "</SubSectionID>\n";
        XML += "<CollectionType>";

        switch (type) {
            case SUBSECTIONS:
                XML += "SUBSECTIONS";
                XML += "</CollectionType>\n";
                for (int i = 0; i < subsectionList.size(); i++) {
                    XML += subsectionList.get(i).toXML();
                }
                break;
            case ANSWERS:
                XML += "ANSWERS";
                XML += "</CollectionType>\n";
                for (int i = 0; i < answerList.size(); i++) {
                    XML += answerList.get(i).toXML();
                }
                break;
            case UNDEFINED:
            default:
                XML += "UNDEFINED";
                XML += "</CollectionType>\n";
                break;
        }
        XML += "</SubmissionSubSection>\n";
        return XML;
    }
}