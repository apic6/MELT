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
class MarkingSubSection {
    ArrayList<MarkingAnswer> answerList;
    
    MarkingSubSection() {
        answerList = new ArrayList<>();
    }
    
    void addAnswer(MarkingAnswer answer) {
        answerList.add(answer);
    }
    
    int getSize() {
        return answerList.size();
    }
    
    MarkingAnswer getAnswer(int id) {
        return answerList.get(id);
    }    
}

class MarkingSection {
    ArrayList<MarkingSubSection> subSectionList;
    
    MarkingSection () {
        subSectionList = new ArrayList<>();
    }
    
    void addSubSection(MarkingSubSection subSection) {
        subSectionList.add(subSection);
    }
    
    int getSize() {
        return subSectionList.size();
    }
    
    MarkingSubSection getSubSection(int id) {
        return subSectionList.get(id);
    }
}

public class MarkingScheme {
    int paperID;
    ArrayList<MarkingSection> sectionList;
    
    int getPaperID() {
        return paperID;
    }
    
    void addSubSection(MarkingSection section) {
        sectionList.add(section);
    }
    
    int getSize() {
        return sectionList.size();
    }
    
    MarkingSection getSection(int id) {
        return sectionList.get(id);
    }
}


