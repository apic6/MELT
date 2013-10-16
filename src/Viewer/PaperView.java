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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jamie
 */
class SectionPanel extends JPanel {

    SectionPanel(final Section section, final JFrame mainFrame, final PaperView pView) {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);

        GridBagConstraints con = new GridBagConstraints();

        con.gridx = 0;
        con.gridy = 0;

        setBackground(new Color(200, 200, 200));

        JLabel title = new JLabel("Title: " + section.getTitle());
        JLabel description = new JLabel("Description: " + section.getDescription());
        JLabel instructions = new JLabel("Instructions: " + section.getInstructions());
        JLabel timeLimit = new JLabel("Time Limit: " + section.getTimeLimit());
        JButton takeTest = new JButton("Take Section");
        
        takeTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new SectionView(section, mainFrame, pView));
                mainFrame.setVisible(true);
               // mainFrame.pack();
                /*
                 * mainFrame.removeAll();
                 mainFrame.add(new SectionView(section));
                 mainFrame.revalidate();
                 mainFrame.repaint();
                 mainFrame.pack(); */
            }
        });

        add(title, con);
        con.gridy++;
        add(description, con);
        con.gridy++;
        add(instructions, con);
        con.gridy++;
        add(timeLimit, con);
        con.gridy++;
        add(takeTest, con);

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    }
    
    
public void addListener(ActionListener mal){


}
}

public class PaperView extends JPanel {

    QuestionPaper paper;
    SectionPanel[] sPanels;

    public PaperView(QuestionPaper paper, final JFrame mainFrame, final Student studentView) {
        this.paper = paper;
        sPanels = new SectionPanel[paper.getNumberOfSections()];

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        
        GridBagConstraints con = new GridBagConstraints();

        con.gridx = 0;
        con.gridy = 0;
        con.fill = GridBagConstraints.HORIZONTAL;
        
        con.ipady = 5;

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(studentView);
                mainFrame.setVisible(true);
                //mainFrame.pack();
            }
        });


        this.add(back, con);
        con.gridy ++;
        for (int i = 0; i < paper.getNumberOfSections(); i++) {
            sPanels[i] = new SectionPanel(paper.getSection(i), mainFrame, this);
            this.add(sPanels[i], con);
            con.gridy ++;
        }

        // JScrollPane scrollPane = new JScrollPane(questionsPanel);        
        // questionsPanel.setPreferredSize(new Dimension(700, 1000));
        // add(scrollPane);
        // add(questionsPanel);
       // this.setSize(new Dimension(700, 600));
        // pack();
    }

    /* public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers("papers/Papers.xml");
        ArrayList<QuestionPaper> papers = model.getPapersByStudentID(12301230);
        QuestionPaper paper = papers.get(0);

        JFrame frame = new JFrame();
        PaperView pView = new PaperView(paper, frame);
        frame.add(pView);

        frame.pack();
        frame.setVisible(true);
    } */

public void addListener(ActionListener mal){


}

}
