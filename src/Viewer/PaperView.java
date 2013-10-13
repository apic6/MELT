/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jamie
 */

class SectionPanel extends JPanel {

    SectionPanel(Section section) {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT, 10, 10);
        setLayout(mainLayout);

        
        GridLayout layout = new GridLayout(0, 1, 10, 10);

        
        setBackground(new Color(200, 200, 200));
        
        JLabel title = new JLabel("Title: " + section.getTitle());
        JLabel description = new JLabel("Description: " + section.getDescription());
        JLabel instructions = new JLabel("Instructions: " + section.getInstructions());
        JLabel timeLimit = new JLabel("Time Limit: " + section.getTimeLimit());
        
        add(title);
        add(description);
        add(instructions);
        add(timeLimit);
        
        setBorder(BorderFactory.createLineBorder(new Color(0,0,0))); 
    }
}

public class PaperView extends JPanel {
    QuestionPaper paper;
    SectionPanel[] sPanels;
    
    public PaperView(QuestionPaper paper) {
        this.paper = paper;
        sPanels = new SectionPanel[paper.getNumberOfSections()];
        
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout layout = new GridLayout(0, 1, 10, 10);
        setLayout(layout);
        
        // questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));
        
        // questions = new Question[subSection.GetNumberOfQuestions()];
        // questionViews = new QuestionView[questions.length];
        
        System.out.println("Number of sections: " + paper.getNumberOfSections());
        for (int i=0; i<paper.getNumberOfSections(); i++) {
            sPanels[i] = new SectionPanel(paper.getSection(i));
            this.add(sPanels[i]);
        }
        
        // JScrollPane scrollPane = new JScrollPane(questionsPanel);        
        // questionsPanel.setPreferredSize(new Dimension(700, 1000));
        // add(scrollPane);
        // add(questionsPanel);
        this.setSize(new Dimension(700, 600)); 
        // pack();
    }
    
    public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers("src/Papers.xml");
        ArrayList<QuestionPaper> papers = model.getPapersByStudentID(12301230);
        QuestionPaper paper = papers.get(0);
        
        JFrame frame = new JFrame();
        PaperView pView = new PaperView(paper);
        frame.add(pView);
        
        frame.pack();
        frame.setVisible(true);
    }    
}

