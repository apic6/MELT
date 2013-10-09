/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

/**
 *
 * @author mbgm8je3
 */
public class SubSectionView extends JFrame {
    Question[] questions;
    QuestionView[] questionViews;
    
    public SubSectionView(SubSection subSection) {
        JPanel questionsPanel = new JPanel();
        questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        
        questions = new Question[subSection.GetNumberOfQuestions()];
        questionViews = new QuestionView[questions.length];
        
        for (int i=0; i<subSection.GetNumberOfQuestions(); i++) {
            questions[i] = subSection.GetQuestion(i);
            questionViews[i] = new QuestionView(questions[i]);
            questionsPanel.add(questionViews[i]);
        }
        
        JScrollPane scrollPane = new JScrollPane(questionsPanel);        
        questionsPanel.setPreferredSize(new Dimension(700, 1000));
        add(scrollPane);
        // add(questionsPanel);
        this.setSize(new Dimension(700, 1000));    
    }
    
    public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers("src/Papers.xml");
        ArrayList<QuestionPaper> papers = model.getPapersByStudentID(12301230);
        QuestionPaper paper = papers.get(0);
        Section section = paper.GetSection(0);
        SubSection subSection = section.GetSubSection(0);
        // QuestionView view = new QuestionView(question);
        // view.setVisible(true);
        new SubSectionView(subSection).setVisible(true);
        
    }    
}
