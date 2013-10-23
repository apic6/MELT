/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.xmlLoaders;

import Model.questionPaper.Section;
import Model.questionPaper.FITBQuestion;
import Model.questionPaper.Question;
import Model.questionPaper.QuestionPaper;
import Model.questionPaper.SubSection;
import Model.questionPaper.MultipleChoiceQuestion;
import Model.questionPaper.MBQuestion;
import Model.questionPaper.EssayQuestion;
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
public class QuestionPaperLoader {

    ArrayList<QuestionPaper> QuestionPapers;
    File XmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;

    public QuestionPaperLoader(String filename) {
        try {
            QuestionPapers = new ArrayList<>();
            XmlFile = new File(filename);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(XmlFile);
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QuestionPaperLoader() {
        this("papers/Papers.xml");
    }

    // returns an integer showing the number of papers read
    public int readPapers() {
        NodeList PaperList = doc.getElementsByTagName("QuestionPaper");

        for (int i = 0; i < PaperList.getLength(); i++) {
            Node QuestionPaperNode = PaperList.item(i);
            Element QPElement = (Element) QuestionPaperNode;

            QuestionPaper paper = new QuestionPaper(Integer.parseInt(QPElement.getAttribute("id")));
            paper.setTitle(QPElement.getElementsByTagName("Title").item(0).getTextContent());
            paper.setDescription(QPElement.getElementsByTagName("Description").item(0).getTextContent());
            paper.setInstructions(QPElement.getElementsByTagName("Instructions").item(0).getTextContent());

            // Eligible students
            for (int j = 0; j < QPElement.getElementsByTagName("EligibleStudent").getLength(); j++) {
                paper.addEligibleStudent(Integer.parseInt(QPElement.getElementsByTagName("EligibleStudent").item(j).getTextContent().toString()));
            }
            // eligible teachers
            for (int j = 0; j < QPElement.getElementsByTagName("EligibleTeacher").getLength(); j++) {
                paper.addEligibleSetter(Integer.parseInt(QPElement.getElementsByTagName("EligibleTeacher").item(j).getTextContent().toString()));
            }

            // Sections
            NodeList SectionList = QPElement.getElementsByTagName("Section");

            for (int j = 0; j < SectionList.getLength(); j++) {
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

                    for (int l = 0; l < QuestionList.getLength(); l++) {
                        Node QuestionNode = QuestionList.item(l);
                        Element QElement = (Element) QuestionNode;

                        Question question = null;

                        if (QElement.getAttribute("type").toString().equals("MCQ")) {
                            String[] answers = new String[QElement.getElementsByTagName("Answer").getLength()];
                            int[] possibleAnswers = new int[QElement.getElementsByTagName("PossibleAnswer").getLength()];
                            for (int m = 0; m < answers.length; m++) {
                                answers[m] = QElement.getElementsByTagName("Answer").item(m).getTextContent();
                            }
                            for (int m = 0; m < possibleAnswers.length; m++) {
                                possibleAnswers[m] = Integer.parseInt(QElement.getElementsByTagName("PossibleAnswer").item(m).getTextContent());
                            }
                            int mark = Integer.parseInt(QElement.getElementsByTagName("Mark").item(0).getTextContent());
                            question = new MultipleChoiceQuestion(QElement.getElementsByTagName("QuestionText").item(0).getTextContent(),
                                    answers,
                                    QElement.getElementsByTagName("Instructions").item(0).getTextContent(), possibleAnswers, mark);
                        } else if (QElement.getAttribute("type").toString().equals("FITBQ")) {
                            // TODO
                            String[] questionParts = new String[2];
                            String[] possibleAnswers = new String[QElement.getElementsByTagName("PossibleAnswer").getLength()];
                            for (int m = 0; m < 2; m++) {
                                questionParts[m] = QElement.getElementsByTagName("QuestionText").item(m).getTextContent();
                            }
                            for (int m = 0; m < possibleAnswers.length; m++) {
                                possibleAnswers[m] = QElement.getElementsByTagName("PossibleAnswer").item(m).getTextContent();
                            }
                            int mark = Integer.parseInt(QElement.getElementsByTagName("Mark").item(0).getTextContent());
                            question = new FITBQuestion(questionParts,
                                    QElement.getElementsByTagName("Instructions").item(0).getTextContent(), possibleAnswers, mark);
                        } else if (QElement.getAttribute("type").toString().equals("MBQ")) {
                            // TODO
                            ArrayList<String> questionParts = new ArrayList<String>();
                            for (int m = 0; m < QElement.getElementsByTagName("QuestionText").getLength(); m++) {
                                System.out.println("Item: " + m);
                                questionParts.add(QElement.getElementsByTagName("QuestionText").item(m).getTextContent());
                            }
                            int mark = Integer.parseInt(QElement.getElementsByTagName("Mark").item(0).getTextContent());
                            question = new MBQuestion(questionParts,
                                    QElement.getElementsByTagName("Instructions").item(0).getTextContent(), mark);
                        } else if (QElement.getAttribute("type").toString().equals("EssayQuestion")) {
                            int mark = Integer.parseInt(QElement.getElementsByTagName("Mark").item(0).getTextContent());
                            question = new EssayQuestion(QElement.getElementsByTagName("QuestionText").item(0).getTextContent(),
                                    QElement.getElementsByTagName("Instructions").item(0).getTextContent(), mark);
                        } else {
                            System.out.println("ERROR");
                        }

                        subSection.addQuestion(l, question);
                    }
                    // Add SubSection to Section
                    section.AddSubSection(k, subSection);
                }

                paper.addSection(j, section);
            }

            // process papers
            QuestionPapers.add(i, paper);
        }

        return QuestionPapers.size();
    }

    public ArrayList<QuestionPaper> getQuestionPapers() {
        return QuestionPapers;
    }

    public QuestionPaper getQuestionPaper(int i) {
        return QuestionPapers.get(i);
    }
}
