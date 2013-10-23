/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mbgm8je3
 */ 
public class SubmissionSection {

    int sectionID;
    ArrayList<SubmissionSubSection> subSectionList;

    public SubmissionSection(int id) {
        this.sectionID = id;
        subSectionList = new ArrayList<>();
    }

    public int getID() {
        return sectionID;
    }

    public void addSubSection(SubmissionSubSection subSection) {
        subSectionList.add(subSection);
    }

    public int getSize() {
        return subSectionList.size();
    }

    public SubmissionSubSection getSubSection(int id) {
        return subSectionList.get(id);
    }

    public void normalise() {
        Collections.sort(subSectionList, new Comparator<SubmissionSubSection>() {
            public int compare(SubmissionSubSection a, SubmissionSubSection b) {
                return a.getID() - b.getID();
            }
        });
        for (int i = 0; i < subSectionList.size(); i++) {
            subSectionList.get(i).normalise();
        }
    }

    public String toXML() {
        String XML = "";
        XML += "<SubmissionSection>\n";
        XML += "<SectionID>" + sectionID + "</SectionID>\n";
        for (int i = 0; i < subSectionList.size(); i++) {
            XML += subSectionList.get(i).toXML() + "\n";
        }
        XML += "</SubmissionSection>\n";
        return XML;
    }
}