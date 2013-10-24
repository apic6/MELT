/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer.PaperViews;

import Model.Modeller;
import Model.questionPaper.QuestionPaper;
import Model.QuestionPaperTaker;
import Model.questionPaper.Section;
import java.awt.Color;
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

    public SectionView(Section section, JFrame frame, final PaperView pView, final QuestionPaperTaker taker, final int sectionID) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        mainFrame = frame;

        con.gridx = 0;
        con.gridy = 0;

        JTabbedPane tabbedPane = new JTabbedPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1075, 700);
            }
        };

        for (int i = 0; i < section.getNumberOfSubSections(); i++) {
            SubSectionView subV = new SubSectionView(section.getSubSection(i), taker, sectionID, i);

            tabbedPane.addTab(section.getSubSection(i).getTitle(), subV);
        }


        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(pView);
                mainFrame.setVisible(true);
            }
        });

        add(back, con);
        con.gridy++;
        add(tabbedPane, con);
    }
    
    public SectionView(Section section, JFrame frame, final PaperView pView, final int sectionID) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        mainFrame = frame;

        con.gridx = 0;
        con.gridy = 0;

        JTabbedPane tabbedPane = new JTabbedPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(1075, 700);
            }
        };

        for (int i = 0; i < section.getNumberOfSubSections(); i++) {
            SubSectionView subV = new SubSectionView(section.getSubSection(i), sectionID, i);

            tabbedPane.addTab(section.getSubSection(i).getTitle(), subV);
        }


        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(pView);
                mainFrame.setVisible(true);
            }
        });

        add(back, con);
        con.gridy++;
        add(tabbedPane, con);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1075, 775);
    }
}
