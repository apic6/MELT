/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mbgm8je3
 */
class SubmissionSubSection {
    int subSectionID;
    ArrayList<Answer> answerList;
    
    SubmissionSubSection(int id) {
        this.subSectionID = id;
        answerList = new ArrayList<>();
    }
    
    int getID() {
        return subSectionID;
    }
    
    void addAnswer(Answer answer) {
        answerList.add(answer);
    }
    
    int getSize() {
        return answerList.size();
    }
    
    Answer getAnswer(int id) {
        return answerList.get(id);
    }    
    
    void normalise() {
        Collections.sort(answerList, new Comparator<Answer>() {
            public int compare(Answer a, Answer b) {
                return a.getID() - b.getID();
            }
        });
    }        
}

class SubmissionSection {
    int sectionID;
    ArrayList<SubmissionSubSection> subSectionList;
    
    SubmissionSection (int id) {
        this.sectionID = id;
        subSectionList = new ArrayList<>();
    }
    
    int getID() {
        return sectionID;
    }
    
    void addSubSection(SubmissionSubSection subSection) {
        subSectionList.add(subSection);
    }
    
    int getSize() {
        return subSectionList.size();
    }
    
    SubmissionSubSection getSubSection(int id) {
        return subSectionList.get(id);
    }
    
    void normalise() {
        Collections.sort(subSectionList, new Comparator<SubmissionSubSection>() {
            public int compare(SubmissionSubSection a, SubmissionSubSection b) {
                return a.getID() - b.getID();
            }
        });
        for (int i = 0; i<subSectionList.size(); i++) {
            subSectionList.get(i).normalise();
        }
    }    
}

public class StudentSubmission {
    int paperID;
    ArrayList<SubmissionSection> sectionList;

    public StudentSubmission(int id) {
        this.paperID = id;
        sectionList = new ArrayList<>();
    }
    
    int getPaperID() {
        return paperID;
    }
    
    void addSection(SubmissionSection section) {
        sectionList.add(section);
    }
    
    int getSize() {
        return sectionList.size();
    }
    
    SubmissionSection getSection(int id) {
        return sectionList.get(id);
    }
    
    void normalise() {
        Collections.sort(sectionList, new Comparator<SubmissionSection>() {
            public int compare(SubmissionSection a, SubmissionSection b) {
                return a.getID() - b.getID();
            }
        });

        for (int i = 0; i<sectionList.size(); i++) {
            sectionList.get(i).normalise();
        }
    }
}


