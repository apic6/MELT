/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author mbgm8je3
 */
class SubmissionSubSection {
    ArrayList<Answer> answerList;
    
    SubmissionSubSection() {
        answerList = new ArrayList<>();
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
}

class SubmissionSection {
    ArrayList<SubmissionSubSection> subSectionList;
    
    SubmissionSection () {
        subSectionList = new ArrayList<>();
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
}

public class StudentSubmission {
    int paperID;
    ArrayList<SubmissionSection> sectionList;
    
    int getPaperID() {
        return paperID;
    }
    
    void addSubSection(SubmissionSection section) {
        sectionList.add(section);
    }
    
    int getSize() {
        return sectionList.size();
    }
    
    SubmissionSection getSection(int id) {
        return sectionList.get(id);
    }
}


