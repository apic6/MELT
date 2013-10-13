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
    
    public void addAnswer(MarkingAnswer answer) {
        answerList.add(answer);
    }
    
    public int getSize() {
        return answerList.size();
    }
    
    public MarkingAnswer getAnswer(int id) {
        return answerList.get(id);
    }    
    
    public String toXML() {
        String XML = "";
        XML += "<MarkingSubSection>\n";
        for (int i = 0; i<answerList.size(); i++) {
            XML += answerList.get(i).toXML() + "\n";
        }
        XML += "</MarkingSubSection>\n";
        return XML;        
    }    
}

class MarkingSection {
    ArrayList<MarkingSubSection> subSectionList;
    
    MarkingSection () {
        subSectionList = new ArrayList<>();
    }
    
    public void addSubSection(MarkingSubSection subSection) {
        subSectionList.add(subSection);
    }
    
    public int getSize() {
        return subSectionList.size();
    }
    
    public MarkingSubSection getSubSection(int id) {
        return subSectionList.get(id);
    }
    
    public String toXML() {
        String XML = "";
        XML += "<MarkingSection>\n";
        for (int i = 0; i<subSectionList.size(); i++) {
            XML += subSectionList.get(i).toXML() + "\n";
        }
        XML += "</MarkingSection>\n";
        return XML;        
    }        
}

public class MarkingScheme {
    int paperID;
    ArrayList<MarkingSection> sectionList;
    
    MarkingScheme(int id) {
        this.paperID = id;
        sectionList = new ArrayList<>();
    }
    
    public int getPaperID() {
        return paperID;
    }
    
    public void addSection(MarkingSection section) {
        sectionList.add(section);
    }
    
    public int getSize() {
        return sectionList.size();
    }
    
    public MarkingSection getSection(int id) {
        return sectionList.get(id);
    }
    
    public String toXML() {
        String XML = "";
        XML += "<MarkingScheme id=\"" + paperID + "\">\n";
        for (int i = 0; i<sectionList.size(); i++) {
            XML += sectionList.get(i).toXML() + "\n";
        }
        XML += "</MarkingScheme>\n";
        return XML;
    }    
}


