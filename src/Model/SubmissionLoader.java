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
        /*
	for (int i = 0; i < submissionList.getLength(); i++) {
            Node submissionNode = submissionList.item(i);
            Element sElement = (Element) submissionNode;
            
            StudentSubmission submission = new Submission(Integer.parseInt(sElement.getAttribute("id")), Integer.parseInt(sElement.getElementsByTagName("StudentID").item(0).getTextContent()));
            
            // Eligible students
            for (int j = 0; j < sElement.getElementsByTagName("SubmissionSection").getLength(); j++) {
                SubmissionSection submSection = new SubmissionSection(i);
                submission.addSection(Integer.parseInt(QPElement.getElementsByTagName("EligibleStudent").item(j).getTextContent().toString()));
            }
            // eligible teachers
            for (int j = 0; j < QPElement.getElementsByTagName("EligibleTeacher").getLength(); j++) {
                System.out.println("I read teacher");
                paper.AddEligibleSetter(Integer.parseInt(QPElement.getElementsByTagName("EligibleTeacher").item(j).getTextContent().toString()));
            }
            
            // Sections
            NodeList SectionList = QPElement.getElementsByTagName("Section");

            for (int j = 0; j < SectionList.getLength(); j++ ) {
                Node SectionNode = SectionList.item(j);
                Element SElement = (Element) SectionNode;
                
                Section section = new Section(Integer.parseInt(SElement.getAttribute("id")), 
                            SElement.getElementsByTagName("Title").item(0).getTextContent(), 
                            SElement.getElementsByTagName("Description").item(0).getTextContent(), 
                            SElement.getElementsByTagName("Instructions").item(0).getTextContent(), 
                            Integer.parseInt(SElement.getElementsByTagName("TimeLimit").item(0).getTextContent()));
                
                // process subsections
                NodeList SubSectionList = SElement.getElementsByTagName("SubSection");
                
                for (int k = 0; k < SubSectionList.getLength(); k++) {
                    Node SubSectionNode = SubSectionList.item(k);
                    Element SSElement = (Element) SubSectionNode;
                    
                    SubSection subSection = new SubSection(SSElement.getElementsByTagName("Title").item(0).getTextContent(), 
                            SSElement.getElementsByTagName("Description").item(0).getTextContent(), 
                            SSElement.getElementsByTagName("Instructions").item(0).getTextContent());
                    
                    // Add Questions
                    NodeList QuestionList = SSElement.getElementsByTagName("Question");
                    
                    System.out.println("Length: " + QuestionList.getLength());
                    for (int l = 0; l < QuestionList.getLength(); l++) {
                        System.out.println("Question: " + l);
                        Node QuestionNode = QuestionList.item(l);
                        Element QElement = (Element) QuestionNode;
                        
                        Question question = null;
                        
                        System.out.print("Entry " + l + " ");
                        if ( QElement.getAttribute("type").toString().equals("MCQ")) {
                            String[] answers = new String[QElement.getElementsByTagName("Answer").getLength()];
                            for (int m = 0; m<answers.length; m++) {
                                answers[m] = QElement.getElementsByTagName("Answer").item(m).getTextContent();
                            }
                            question = new MultipleChoiceQuestion(QElement.getElementsByTagName("QuestionText").item(0).getTextContent(), 
                                            answers, 
                                            QElement.getElementsByTagName("Instructions").item(0).getTextContent());
                        } else if (QElement.getAttribute("type").toString().equals("FITBQ") ) {
                            question = new FITBQuestion(QElement.getElementsByTagName("QuestionText").item(0).getTextContent(), 
                                            QElement.getElementsByTagName("Instructions").item(0).getTextContent());
                        } else {
                            System.out.println("ERROR");
                        }
                        
                        subSection.AddQuestion(l, question);
                    }
                    // Add SubSection to Section
                    section.AddSubSection(k, subSection);
                }
                
                paper.AddSection(j, section);
            } 
            
            // process papers
            QuestionPapers.add(i, paper);
        }   */    
        
        return submissions.size();
    }
    
    ArrayList<StudentSubmission> getQuestionPapers() {
        return submissions;
    }
    
    StudentSubmission getQuestionPaper(int i) {
        return submissions.get(i);
    }
}