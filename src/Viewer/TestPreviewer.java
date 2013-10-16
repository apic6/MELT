/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.Question;
import Model.QuestionPaper;
import Model.Section;
import Model.SubSection;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author mbaxkak4
 */
public final class TestPreviewer extends JFrame {

    private Modeller amodel;
    private int paperNo;
    private QuestionPaper qpaper;

    public TestPreviewer(Modeller model, QuestionPaper paper) {      //constructor
        this.qpaper = paper;
        amodel = model;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents(paperNo);
        setVisible(true);

    }

    void initComponents(int j) {
        Question[] questions;
        QuestionView[] questionViews;

        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));


        amodel.loadPapers("papers/Papers.xml");
        ArrayList<QuestionPaper> papers = amodel.getPapersByStudentID(12301230);

        QuestionPaper paper = papers.get(0);
        Section section = paper.getSection(0);
        SubSection subSection = section.getSubSection(0);
        questions = new Question[subSection.getNumberOfQuestions()];
        questionViews = new QuestionView[questions.length];

        for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
            questions[i] = subSection.getQuestion(i);
            questionViews[i] = new QuestionView(questions[i]);
            questionsPanel.add(questionViews[i]);
        }

        JScrollPane scrollPane = new JScrollPane(questionsPanel);
        questionsPanel.setPreferredSize(new Dimension(700, 1000));
        add(scrollPane);
        // add(questionsPanel);
        this.setSize(new Dimension(700, 1000));
    }
}
