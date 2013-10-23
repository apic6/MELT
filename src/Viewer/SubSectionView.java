/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.questionPaper.Question;
import Model.questionPaper.SubSection;
import javax.swing.JPanel;
import Model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;

/**
 *
 * @author mbgm8je3
 */
public class SubSectionView extends JPanel {

    Question[] questions;
    QuestionView[] questionViews;
    // int height;

    public SubSectionView(SubSection subSection, final QuestionPaperTaker taker, final int sectionID, final int subSectionID) {
        JPanel questionsPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = 1050;
                return d;
            }
        };

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.NORTH;
        con.fill = GridBagConstraints.NONE;
        questionsPanel.setLayout(layout);

        GridBagConstraints vertFill = new GridBagConstraints();


        JScrollPane scrollPane = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                //Dimension d = super.getPreferredSize();
                //d.width = 1050;
                //return d;
                return new Dimension(1050, 750);
            }
        };

        questions = new Question[subSection.getNumberOfQuestions()];
        questionViews = new QuestionView[questions.length];

        for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
            questions[i] = subSection.getQuestion(i);
            questionViews[i] = new QuestionView(questions[i], taker, sectionID, subSectionID, i);
            questionsPanel.add(questionViews[i], con);
            con.gridy++;
        }
        vertFill = con;
        vertFill.anchor = GridBagConstraints.NORTH;
        vertFill.fill = GridBagConstraints.VERTICAL;
        
        questionsPanel.setAlignmentX(TOP_ALIGNMENT);
        questionsPanel.add(Box.createVerticalBox(), vertFill);
        scrollPane.getViewport().add(questionsPanel, null);

        this.add(scrollPane, null);
        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPane);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1050, 750);
    }
}
