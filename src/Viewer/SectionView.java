/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author mbgm8je3
 */
public class SectionView extends JPanel {

    QuestionPaper sourcePaper;
    JFrame mainFrame;
    SubSectionView[] subSectionViews;

    public SectionView(Section section, JFrame frame, QuestionPaper paper) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        sourcePaper = paper;
        mainFrame = frame;

        con.gridx = 0;
        con.gridy = 0;
        
        JTabbedPane tabbedPane = new JTabbedPane() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 600;
                return d;
            }
        };

        // questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));

        // questions = new Question[subSection.GetNumberOfQuestions()];
        // questionViews = new QuestionView[questions.length];

        for (int i = 0; i < section.getNumberOfSubSections(); i++) {
            tabbedPane.addTab(section.getSubSection(i).getTitle(), new SubSectionView(section.getSubSection(i)));
        }

        // JScrollPane scrollPane = new JScrollPane(questionsPanel);        
        // questionsPanel.setPreferredSize(new Dimension(700, 1000));
        // add(scrollPane);
        // add(questionsPanel);
        // this.setSize(new Dimension(700, 600)); 
        // tabbedPane.setSize(650, 600);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new PaperView(sourcePaper, mainFrame));
                mainFrame.setVisible(true);
                mainFrame.pack();
            }
        });

        add(back, con);
        con.gridy ++;
        add(tabbedPane, con);
    }

    public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers("papers/Papers.xml");
        ArrayList<QuestionPaper> papers = model.getPapersByStudentID(12301230);
        QuestionPaper paper = papers.get(0);
        Section section = paper.getSection(0);

        JFrame frame = new JFrame();

        frame.add(new SectionView(section, frame, paper));
        // frame.add(new SubSectionView(section.getSubSection(0)));
        // frame.setPreferredSize(new Dimension(650, 650));
        frame.pack();

        frame.setVisible(true);
    }
}