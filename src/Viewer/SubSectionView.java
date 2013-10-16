/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import javax.swing.JPanel;
import Model.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author mbgm8je3
 */
public class SubSectionView extends JPanel {

    Question[] questions;
    QuestionView[] questionViews;
    // int height;

    public SubSectionView(SubSection subSection) {
        JPanel questionsPanel = new JPanel(){
            @Override
            public Dimension getPreferredSize() {
                Dimension d = new Dimension();
                d.height = 650;
                d.width = super.getPreferredSize().width;
                return d;
            }
        };

        GridLayout layout = new GridLayout(0, 1);
        questionsPanel.setLayout(layout);

        JScrollPane scrollPane = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = new Dimension();
                d.height = 650;
                d.width = super.getPreferredSize().width;
                return d;
            }
        };

        // height = 0;  

        questions = new Question[subSection.getNumberOfQuestions()];
        questionViews = new QuestionView[questions.length];

        for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
            questions[i] = subSection.getQuestion(i);
            questionViews[i] = new QuestionView(questions[i]);
            questionsPanel.add(questionViews[i]);
            // con.gridy++;
            // height += questionViews[i].getHeight();
        }
        scrollPane.getViewport().add(questionsPanel, null);

        this.add(scrollPane, null);
        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPane);

        // scrollPane.setViewportView(questionsPanel);
        // questionsPanel.setPreferredSize(new Dimension(650, 1000));
        // scrollPane.setSize(new Dimension(650, 600));
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.width = 550;
        return d;
    }
}
