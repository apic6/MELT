/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author mbgm8je3
 */
public class SectionView  extends JFrame {
    SubSectionView[] subSectionViews;
    
    public SectionView(Section section) {
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        
        // questions = new Question[subSection.GetNumberOfQuestions()];
        // questionViews = new QuestionView[questions.length];
        
        for (int i=0; i<section.GetNumberOfSubSections(); i++) {
            tabbedPane.addTab(section.GetSubSection(i).GetTitle(),new SubSectionView(section.GetSubSection(i)));
        }
        
        // JScrollPane scrollPane = new JScrollPane(questionsPanel);        
        // questionsPanel.setPreferredSize(new Dimension(700, 1000));
        // add(scrollPane);
        // add(questionsPanel);
        this.setSize(new Dimension(700, 600)); 
        tabbedPane.setSize(650, 600);
        add(tabbedPane);
    }
    
    public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers("src/Papers.xml");
        ArrayList<QuestionPaper> papers = model.getPapersByStudentID(12301230);
        QuestionPaper paper = papers.get(0);
        Section section = paper.GetSection(0);
        
        new SectionView(section).setVisible(true);
        
    }    
}