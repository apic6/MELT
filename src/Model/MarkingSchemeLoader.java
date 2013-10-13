/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Jamie
 */
public class MarkingSchemeLoader {

    ArrayList<MarkingScheme> markingSchemes;
    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;

    MarkingSchemeLoader() {
        this("markingSchemes/MarkingSchemes.xml");
    }

    MarkingSchemeLoader(String filename) {
        try {
            markingSchemes = new ArrayList<>();
            xmlFile = new File(filename);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // returns an integer showing the number of papers read
    int loadMarkingSchemes() {
        NodeList markingSchemesList = doc.getElementsByTagName("MarkingScheme");

        for (int i = 0; i < markingSchemesList.getLength(); i++) {
            Node markingSchemeNode = markingSchemesList.item(i);
            Element msElement = (Element) markingSchemeNode;

            MarkingScheme scheme = new MarkingScheme(Integer.parseInt(msElement.getAttribute("id")));

            // For each section
            NodeList schemeSectionList = msElement.getElementsByTagName("MarkingSection");
            for (int j = 0; j < schemeSectionList.getLength(); j++) {
                Element mssElement = (Element) schemeSectionList.item(j);
                MarkingSection msSection = new MarkingSection();

                NodeList schemeSubSectionList = mssElement.getElementsByTagName("MarkingSubSection");
                for (int k = 0; k < schemeSubSectionList.getLength(); k++) {
                    Element msssElement = (Element) schemeSubSectionList.item(k);
                    MarkingSubSection schemeSubSection = new MarkingSubSection();

                    NodeList schemeAnswerList1 = msssElement.getElementsByTagName("MCQAnswer");
                    NodeList schemeAnswerList2 = msssElement.getElementsByTagName("FITBAnswer");
                    for (int l = 0; l < schemeAnswerList1.getLength(); l++) {
                        Element schemeMCQAnswer = (Element) schemeAnswerList1.item(l);
                        MCQMarkingAnswer answer = new MCQMarkingAnswer(Integer.parseInt(schemeMCQAnswer.getElementsByTagName("Answer").item(0).getTextContent()),
                                Integer.parseInt(schemeMCQAnswer.getElementsByTagName("Mark").item(0).getTextContent()));

                        schemeSubSection.addAnswer(answer);
                    }
                    for (int l = 0; l < schemeAnswerList2.getLength(); l++) {
                        Element schemeFITBAnswer = (Element) schemeAnswerList2.item(l);
                        FITBMarkingAnswer answer = new FITBMarkingAnswer(schemeFITBAnswer.getElementsByTagName("Answer").item(0).getTextContent(),
                                    Integer.parseInt(schemeFITBAnswer.getElementsByTagName("Mark").item(0).getTextContent()));

                        schemeSubSection.addAnswer(answer);
                    }

                    msSection.addSubSection(schemeSubSection);
                }

                // scheme.normalise();
                scheme.addSection(msSection);
            }

            // add submission
            markingSchemes.add(scheme);
        }

        return markingSchemes.size();
    }

    ArrayList<MarkingScheme> getMarkingSchemes() {
        return markingSchemes;
    }

    MarkingScheme getMarkingScheme(int i) {
        return markingSchemes.get(i);
    }
}
