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
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author mbgm8je3
 */
public class SectionView extends JPanel {

    QuestionPaper sourcePaper;
    Section section;
    JFrame mainFrame;
    SubSectionView[] subSectionViews;
    JTabbedPane tabbedPane;
    JLabel timeRemaining;
    PaperView pView;
    int sectionID;

    public SectionView(Section section, JFrame frame, final PaperView pView, final QuestionPaperTaker taker, final int sectionID) {
        this.pView = pView;
        this.sectionID = sectionID;
        this.setLayout(new GridBagLayout());
        this.section = section;
        GridBagConstraints con = new GridBagConstraints();

        mainFrame = frame;

        con.gridx = 0;
        con.gridy = 0;

        tabbedPane = new JTabbedPane() {
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
                pView.returnAndUpdateTimer(sectionID);
            }
        });

        timeRemaining = new JLabel("Time remaining: " + giveIntAsTime(section.getRemainingTime()));
        ActionListener aListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateTime();
            }
        };
        section.startTimer(aListener);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(back);
        topPanel.add(timeRemaining);

        add(topPanel, con);

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

    public void setSelectedSubSection(int i) {
        tabbedPane.setSelectedIndex(i);
    }

    private void updateTime() {
        System.out.println("Time: " + section.getRemainingTime());
        section.timerTick();
        int remaining = section.getRemainingTime();
        if (remaining == 0) {
            mainFrame.setContentPane(pView);
            mainFrame.setVisible(true);
            pView.returnAndUpdateTimer(sectionID);
        }
        timeRemaining.setText("Time remaining: " + giveIntAsTime(remaining));
        this.repaint();
        this.revalidate();
    }

    private String giveIntAsTime(int time) {
        String timer;

        int hours = time % 3600000;
        hours = (time - hours) / 3600000;

        time -= hours * 3600000;
        int minutes = time % 60000;
        minutes = (time - minutes) / 60000;

        time -= minutes * 60000;
        time /= 1000;

        if (hours > 0) {
            timer = hours + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", time);
        } else {
            timer = minutes + ":" + String.format("%02d", time);
        }

        return timer;
    }
}
