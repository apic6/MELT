/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer.PaperViews;

import Model.Marker;
import Model.Modeller;
import Model.questionPaper.QuestionPaper;
import Model.QuestionPaperTaker;
import Model.StudentSubmission.Submission;
import Model.questionPaper.Section;
import Viewer.Popup;
import Viewer.Student;
import Viewer.TeacherView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

    private Section section;
    private JLabel timeRemaining;
    JButton takeTest;

    SectionPanel(final Section section, final JFrame mainFrame, final PaperView pView, final QuestionPaperTaker taker, final int sectionID) {
        this.section = section;

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);

        GridBagConstraints con = new GridBagConstraints();

        con.gridx = 0;
        con.gridy = 0;
        con.ipadx = 10;
        con.ipady = 10;


        setBackground(new Color(200, 200, 200));

        JLabel title = new JLabel("Title: " + section.getTitle());
        JLabel description = new JLabel("Description: " + section.getDescription());
        JLabel instructions = new JLabel("Instructions: " + section.getInstructions());
        section.setupTimer();
        timeRemaining = new JLabel("Time Limit: " + giveIntAsTime(section.getRemainingTime()));

        takeTest = new JButton("Take Section");

        takeTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new SectionView(section, mainFrame, pView, taker, sectionID));
                mainFrame.setVisible(true);
            }
        });

        add(title, con);
        con.gridy++;
        add(description, con);
        con.gridy++;
        add(instructions, con);
        con.gridy++;
        add(timeRemaining, con);
        con.gridy++;
        add(takeTest, con);

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    }

    SectionPanel(final Section section, final JFrame mainFrame, final PaperView pView, final int sectionID) {
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
                mainFrame.setContentPane(new SectionView(section, mainFrame, pView, sectionID));
                mainFrame.setVisible(true);
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

    public void updateTimer() {
        ActionListener aListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateTime();
            }
        };
        section.updateListener(aListener);

        int remaining = section.getRemainingTime();
        timeRemaining.setText("Time remaining: " + giveIntAsTime(remaining));
    }

    private void updateTime() {
        section.timerTick();
        int remaining = section.getRemainingTime();
        if (remaining <= 0) {
            section.stopTimer();
            takeTest.setEnabled(false);
            timeRemaining.setText("Time elapsed, your work has been saved.");
        } else {
            timeRemaining.setText("Time remaining: " + giveIntAsTime(remaining));
        }

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

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.width = 1000;
        return d;
    }
}

public class PaperView extends JPanel {

    QuestionPaper paper;
    static QuestionPaperTaker taker;
    SectionPanel[] sPanels;

    public PaperView(final QuestionPaper paper, final JFrame mainFrame, final Student studentView, int studentID) {
        
        this.paper = paper;

        if (studentID >= 0) {
            taker = new QuestionPaperTaker(paper, studentID);
        } else {
            taker = null;
        }

        sPanels = new SectionPanel[paper.getNumberOfSections()];

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints con = new GridBagConstraints();

        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(10, 10, 10, 10);

        JPanel buttons = new JPanel();

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(studentView);
                mainFrame.setVisible(true);
                //mainFrame.pack();
            }
        });

        JPanel paperInfo = new JPanel();
        JLabel title = new JLabel("Paper Title: " + paper.getTitle());
        JLabel description = new JLabel("Paper Description: " + paper.getDescription());
        JLabel instructions = new JLabel("Paper Instructions: " + paper.getTitle());
        
        paperInfo.setLayout(new GridBagLayout());
        GridBagConstraints con2 = new GridBagConstraints();
        con2.gridx = 0;
        con2.gridy = 0;
        
        paperInfo.add(title, con2);
        con2.gridy++;
        paperInfo.add(description, con2);
        con2.gridy++;
        paperInfo.add(instructions, con2);
        
        this.add(paperInfo, con);
        con.gridy++;        
        
        for (int i = 0; i < paper.getNumberOfSections(); i++) {
            sPanels[i] = new SectionPanel(paper.getSection(i), mainFrame, this, taker, i);
            this.add(sPanels[i], con);
            con.gridy++;
        }



        JButton finish = new JButton("Finish");
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Submission subm = taker.getSubmission();
                subm.normalise();

                Marker marker = new Marker();
                marker.markTest(taker.getSubmission(), paper);

                // System.out.println("Mark = " + marker.getMark() + "/" + marker.getTotalMark());
            }
        });

        buttons.setLayout(new FlowLayout());
        buttons.add(back);
        buttons.add(finish);
        this.add(buttons, con);
    }

    public PaperView(QuestionPaper paper, final JFrame mainFrame, final TeacherView teacherView) {
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
                mainFrame.setContentPane(teacherView);
                mainFrame.setVisible(true);
            }
        });


        this.add(back, con);
        con.gridy++;
        for (int i = 0; i < paper.getNumberOfSections(); i++) {
            sPanels[i] = new SectionPanel(paper.getSection(i), mainFrame, this, i);
            this.add(sPanels[i], con);
            con.gridy++;
        }

        JButton finish = new JButton("Finish");
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popup pop = new Popup();
                pop.setText("Cannot save as teacher.");
                pop.show();
            }
        });
        this.add(finish, con);
    }

    public PaperView(QuestionPaper paper, final JFrame mainFrame, final TeacherView teacherView, int[] sectionAndSubSection) {
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
                mainFrame.setContentPane(teacherView);
                mainFrame.setVisible(true);
            }
        });


        this.add(back, con);
        con.gridy++;
        for (int i = 0; i < paper.getNumberOfSections(); i++) {
            sPanels[i] = new SectionPanel(paper.getSection(i), mainFrame, this, i);
            this.add(sPanels[i], con);
            con.gridy++;
        }

        JButton finish = new JButton("Finish");
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popup pop = new Popup();
                pop.setText("Cannot save as teacher.");
                pop.show();
            }
        });
        this.add(finish, con);

        SectionView sView = new SectionView(paper.getSection(sectionAndSubSection[0]), mainFrame, this, sectionAndSubSection[0]);
        sView.setSelectedSubSection(sectionAndSubSection[1]);
        mainFrame.setContentPane(sView);
        mainFrame.setVisible(true);
    }

    public void returnAndUpdateTimer(int sectionID) {
        // update timer
        sPanels[sectionID].updateTimer();
    }

    public void addListener(ActionListener mal) {
    }

    public static Submission getSubmission() {
        return taker.getSubmission();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.height = 800;
        d.width = 1100;
        return d;
    }
}
