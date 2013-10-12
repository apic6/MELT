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
public class SubmissionLoader {

    ArrayList<StudentSubmission> submissions;
    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;

    SubmissionLoader() {
        this("submissions/Submissions.xml");
    }

    SubmissionLoader(String filename) {
        try {
            submissions = new ArrayList<>();
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
    int loadSubmissions() {
        NodeList submissionList = doc.getElementsByTagName("StudentSubmission");

        for (int i = 0; i < submissionList.getLength(); i++) {
            Node submissionNode = submissionList.item(i);
            Element sElement = (Element) submissionNode;

            StudentSubmission submission = new StudentSubmission(Integer.parseInt(sElement.getAttribute("id")), Integer.parseInt(sElement.getElementsByTagName("StudentID").item(0).getTextContent()));

            // For each section
            NodeList submissionSectionList = sElement.getElementsByTagName("SubmissionSection");
            for (int j = 0; j < submissionSectionList.getLength(); j++) {
                Element ssElement = (Element) submissionSectionList.item(j);
                SubmissionSection submSection = new SubmissionSection(Integer.parseInt(ssElement.getElementsByTagName("SectionID").item(0).getTextContent()));

                NodeList submissionSubSectionList = ssElement.getElementsByTagName("SubmissionSubSection");
                for (int k = 0; k < submissionSubSectionList.getLength(); k++) {
                    Element sssElement = (Element) submissionSubSectionList.item(k);
                    SubmissionSubSection submSubSection = new SubmissionSubSection(Integer.parseInt(sssElement.getElementsByTagName("SubSectionID").item(0).getTextContent()));
                    
                    NodeList submissionAnswerList1 = sssElement.getElementsByTagName("MCQAnswer");
                    NodeList submissionAnswerList2 = sssElement.getElementsByTagName("FITBAnswer");
                    for (int l = 0; l < submissionAnswerList1.getLength(); l++) {
                        Element sMCQAnswer = (Element) submissionAnswerList1.item(l);
                        MCQAnswer answer = new MCQAnswer(Integer.parseInt(sMCQAnswer.getElementsByTagName("AnswerID").item(0).getTextContent()), 
                                                         Integer.parseInt(sMCQAnswer.getElementsByTagName("Answer").item(0).getTextContent()));
                        
                        submSubSection.addAnswer(answer);
                    }
                    for (int l = 0; l < submissionAnswerList2.getLength(); l++) {
                        Element sFITBAnswer = (Element) submissionAnswerList1.item(l);
                        FITBAnswer answer = new FITBAnswer(Integer.parseInt(sFITBAnswer.getElementsByTagName("AnswerID").item(0).getTextContent()), 
                                                         sFITBAnswer.getElementsByTagName("Answer").item(0).getTextContent());
                        
                        submSubSection.addAnswer(answer);                        
                    }
                    
                    submSection.addSubSection(submSubSection);
                }

                submission.normalise();
                submission.addSection(submSection);
            }

            // add submission
            submissions.add(submission);
        }

        return submissions.size();
    }

    ArrayList<StudentSubmission> getSubmissions() {
        return submissions;
    }

    StudentSubmission getSubmission(int i) {
        return submissions.get(i);
    }
}
