/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.xmlLoaders;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import Model.StudentSubmission.*;

/**
 *
 * @author Jamie
 */
public class SubmissionLoader {

    ArrayList<Submission> submissions;
    File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;

    public SubmissionLoader() {
        this("submissions/Submissions.xml");
    }

    public SubmissionLoader(String filename) {
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
    public int loadSubmissions() {
        NodeList submissionList = doc.getElementsByTagName("StudentSubmission");

        for (int i = 0; i < submissionList.getLength(); i++) {
            Node submissionNode = submissionList.item(i);
            Element sElement = (Element) submissionNode;

            Submission submission = new Submission(Integer.parseInt(sElement.getElementsByTagName("PaperID").item(0).getTextContent()), Integer.parseInt(sElement.getElementsByTagName("StudentID").item(0).getTextContent()));

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
                    NodeList submissionAnswerList3 = sssElement.getElementsByTagName("MFITBAnswer");
                    NodeList submissionAnswerList4 = sssElement.getElementsByTagName("EssayAnswer");
                    
                    // parse MCQ Answers
                    for (int l = 0; l < submissionAnswerList1.getLength(); l++) {
                        Element sMCQAnswer = (Element) submissionAnswerList1.item(l);
                        MCQAnswer answer = new MCQAnswer(Integer.parseInt(sMCQAnswer.getElementsByTagName("AnswerID").item(0).getTextContent()), 
                                                         Integer.parseInt(sMCQAnswer.getElementsByTagName("Answer").item(0).getTextContent()));
                        
                        submSubSection.addAnswer(answer);
                    }
                    
                    // parse FITB Answers
                    for (int l = 0; l < submissionAnswerList2.getLength(); l++) {
                        Element sFITBAnswer = (Element) submissionAnswerList2.item(l);
                        FITBAnswer answer = new FITBAnswer(Integer.parseInt(sFITBAnswer.getElementsByTagName("AnswerID").item(0).getTextContent()), 
                                                         sFITBAnswer.getElementsByTagName("Answer").item(0).getTextContent());
                        
                        submSubSection.addAnswer(answer);                        
                    }
                    
                    // parse MFITB Answers
                    for (int l = 0; l < submissionAnswerList3.getLength(); l++) {
                        Element sMFITBAnswer = (Element) submissionAnswerList3.item(l);
                        ArrayList<String> strings = new ArrayList<String>();
                        NodeList answers = sMFITBAnswer.getElementsByTagName("Answer");
                        for (int m = 0; m<answers.getLength(); m++)
                            strings.add(answers.item(m).getTextContent());
                        MFITBAnswer answer = new MFITBAnswer(Integer.parseInt(sMFITBAnswer.getElementsByTagName("AnswerID").item(0).getTextContent()), 
                                                         strings);
                        
                        submSubSection.addAnswer(answer);                        
                    }
                    for (int l = 0; l < submissionAnswerList4.getLength(); l++) {
                        Element sEssayAnswer = (Element) submissionAnswerList4.item(l);
                        EssayAnswer answer = new EssayAnswer(Integer.parseInt(sEssayAnswer.getElementsByTagName("AnswerID").item(0).getTextContent()), 
                                                         sEssayAnswer.getElementsByTagName("Answer").item(0).getTextContent());
                        
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

    public ArrayList<Submission> getSubmissions() {
        return submissions;
    }

    public Submission getSubmission(int i) {
        return submissions.get(i);
    }
}
