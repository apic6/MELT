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
            System.err.println(e);
        }
    }

    public QuestionPaperLoader() {
        this("papers/Papers.xml");
    }

    public QuestionPaper readPaper(Element qpElement) {
        // create paper with ID
        QuestionPaper paper = new QuestionPaper(Integer.parseInt(qpElement.getAttribute("id")));
        // set title, decsription and Instructions
        paper.setTitle(qpElement.getElementsByTagName("Title").item(0).getTextContent());
        paper.setDescription(qpElement.getElementsByTagName("Description").item(0).getTextContent());
        paper.setInstructions(qpElement.getElementsByTagName("Instructions").item(0).getTextContent());

        // Add Eligible students
        for (int i = 0; i < qpElement.getElementsByTagName("EligibleStudent").getLength(); i++) {
            paper.addEligibleStudent(Integer.parseInt(qpElement.getElementsByTagName("EligibleStudent").item(i).getTextContent().toString()));
        }
        // Add eligible teachers
        for (int i = 0; i < qpElement.getElementsByTagName("EligibleTeacher").getLength(); i++) {
            paper.addEligibleSetter(Integer.parseInt(qpElement.getElementsByTagName("EligibleTeacher").item(i).getTextContent().toString()));
        }

        // Get a list of sections
        NodeList SectionList = qpElement.getElementsByTagName("Section");

        // for each section element
        for (int i = 0; i < SectionList.getLength(); i++) {
            // get the element
            Element sElement = (Element) SectionList.item(i);

            // parse the section
            Section section = readSection(sElement);
            // add to paper
            paper.addSection(i, section);
        } // for

        return paper;
    }

    public Section readSection(Element sElement) {
        // create new section
        Section section = new Section(Integer.parseInt(sElement.getAttribute("id")),
                sElement.getElementsByTagName("Title").item(0).getTextContent(),
                sElement.getElementsByTagName("Description").item(0).getTextContent(),
                sElement.getElementsByTagName("Instructions").item(0).getTextContent(),
                Integer.parseInt(sElement.getElementsByTagName("TimeLimit").item(0).getTextContent()));

        // process subsections
        NodeList SubSectionList = sElement.getElementsByTagName("SubSection");

        // for each subsection
        for (int i = 0; i < SubSectionList.getLength(); i++) {
            // get element
            Element ssElement = (Element) SubSectionList.item(i);
            // and parse it
            if (ssElement.getParentNode() == sElement) {
                SubSection subSection = readSubSection(ssElement);

                // Add SubSection to Section
                section.AddSubSection(i, subSection);
            }
        }
        return section;
    }

    public SubSection readSubSection(Element ssElement) {
        // create subsection
        SubSection subSection = new SubSection(ssElement.getElementsByTagName("Title").item(0).getTextContent(),
                ssElement.getElementsByTagName("Description").item(0).getTextContent(),
                ssElement.getElementsByTagName("Instructions").item(0).getTextContent());

        // if it is a recursive subsection
        if (ssElement.getElementsByTagName("CollectionType").item(0).getTextContent().equals("SUBSECTIONS")) {
            // add the subsections using this function recursively
            NodeList subSectionList = ssElement.getElementsByTagName("SubSection");
            for (int i = 0; i < subSectionList.getLength(); i++) {
                Element ssElementN = (Element) subSectionList.item(i);

                if (ssElementN.getParentNode() == ssElement) {
                    SubSection subSectionN = readSubSection(ssElementN);

                    // Add SubSection to Section
                    subSection.addSubSection(subSectionN);
                }

            }
        } if (ssElement.getElementsByTagName("CollectionType").item(0).getTextContent().equals("QUESTIONS")) { // if it is composed of questions
            // add the questions to this subsection
            System.out.println("Questions");
            NodeList QuestionList = ssElement.getElementsByTagName("Question");

            for (int i = 0; i < QuestionList.getLength(); i++) {
                Element qElement = (Element) QuestionList.item(i);

                Question question = readQuestion(qElement);

                subSection.addQuestion(i, question);
            }
        }

        return subSection;

    }

    public Question readQuestion(Element qElement) {
        Question question = null;

        switch (qElement.getAttribute("type").toString()) {
            case "MCQ": {
                String[] answers = new String[qElement.getElementsByTagName("Answer").getLength()];
                int[] possibleAnswers = new int[qElement.getElementsByTagName("PossibleAnswer").getLength()];
                // parse the answers of the multiple choice question
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = qElement.getElementsByTagName("Answer").item(i).getTextContent();
                }
                // parse the possible "correct" answers
                for (int i = 0; i < possibleAnswers.length; i++) {
                    possibleAnswers[i] = Integer.parseInt(qElement.getElementsByTagName("PossibleAnswer").item(i).getTextContent());
                }
                int mark = Integer.parseInt(qElement.getElementsByTagName("Mark").item(0).getTextContent());
                question = new MultipleChoiceQuestion(qElement.getElementsByTagName("QuestionText").item(0).getTextContent(),
                        answers,
                        qElement.getElementsByTagName("Instructions").item(0).getTextContent(), possibleAnswers, mark);
                break;
            }
            case "FITBQ": {
                // TODO
                String[] questionParts = new String[2];
                String[] possibleAnswers = new String[qElement.getElementsByTagName("PossibleAnswer").getLength()];
                // parse the two string fragments
                for (int i = 0; i < 2; i++) {
                    questionParts[i] = qElement.getElementsByTagName("QuestionText").item(i).getTextContent();
                }
                // parse the acceptable answers
                for (int i = 0; i < possibleAnswers.length; i++) {
                    possibleAnswers[i] = qElement.getElementsByTagName("PossibleAnswer").item(i).getTextContent();
                }
                int mark = Integer.parseInt(qElement.getElementsByTagName("Mark").item(0).getTextContent());
                question = new FITBQuestion(questionParts,
                        qElement.getElementsByTagName("Instructions").item(0).getTextContent(), possibleAnswers, mark);
                break;
            }
            case "MBQ": {
                // TODO
                ArrayList<String> questionParts = new ArrayList<>();
                for (int i = 0; i < qElement.getElementsByTagName("QuestionText").getLength(); i++) {
                    questionParts.add(qElement.getElementsByTagName("QuestionText").item(i).getTextContent());
                }
                int mark = Integer.parseInt(qElement.getElementsByTagName("Mark").item(0).getTextContent());
                question = new MBQuestion(questionParts,
                        qElement.getElementsByTagName("Instructions").item(0).getTextContent(), mark);
                break;
            }
            case "EssayQuestion": {
                int mark = Integer.parseInt(qElement.getElementsByTagName("Mark").item(0).getTextContent());
                question = new EssayQuestion(qElement.getElementsByTagName("QuestionText").item(0).getTextContent(),
                        qElement.getElementsByTagName("Instructions").item(0).getTextContent(), mark);
                break;
            }
            default:
                System.out.println("ERROR");
                break;
        }

        return question;
    }

    // returns an integer showing the number of papers read
    public int readPapers() {
        NodeList PaperList = doc.getElementsByTagName("QuestionPaper");

        // for each element that represents a paper
        for (int i = 0; i < PaperList.getLength(); i++) {
            // get the element
            Element qpElement = (Element) PaperList.item(i);
            // parse it
            QuestionPaper paper = readPaper(qpElement);
            // add it
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
