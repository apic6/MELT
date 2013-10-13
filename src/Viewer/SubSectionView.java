/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import javax.swing.JPanel;
import Model.*;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author mbgm8je3
 */
public class SubSectionView extends JScrollPane {
    Question[] questions;
    QuestionView[] questionViews;
    // int height;
    
    public SubSectionView(SubSection subSection) {
        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        
        // height = 0;  
        
        questions = new Question[subSection.getNumberOfQuestions()];
        questionViews = new QuestionView[questions.length];
        
        for (int i=0; i<subSection.getNumberOfQuestions(); i++) {
            questions[i] = subSection.getQuestion(i);
            questionViews[i] = new QuestionView(questions[i]);
            questionsPanel.add(questionViews[i]);
            // height += questionViews[i].getHeight();
        }
        
        setViewportView(questionsPanel);
        // questionsPanel.setPreferredSize(new Dimension(650, 1000));
        this.setSize(new Dimension(650, 600)); 
        
    }
}
