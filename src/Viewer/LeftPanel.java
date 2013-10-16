/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author mbgm8je3
 */
class QuestionPanel extends JPanel {

    String question;
    String[] answers;

    public QuestionPanel(String question, String[] answers) {
        GridBagLayout layout = new GridBagLayout();

        GridBagConstraints con = new GridBagConstraints();

        //con.ipadx = 10;
        //con.ipady = 10;

        con.anchor = GridBagConstraints.LINE_START;
        con.insets = new Insets(5, 5, 5, 5);
        con.weightx = 1;

        con.gridx = 0;
        con.gridy = 0;

        con.fill = GridBagConstraints.VERTICAL;

        layout.setConstraints(this, con);

        // this.setBackground(new Color(255, 0, 0));
        this.setLayout(layout);

        this.question = question;
        JLabel questionLabel = new JLabel(this.question);
        this.add(questionLabel, con);

        this.answers = answers;

        Border b = new LineBorder(new Color(0, 0, 0));
        this.setBorder(b);

        for (int i = 0; i < answers.length; i++) {
            JRadioButton radio = new JRadioButton(answers[i]);
            con.gridy = i + 1;
            this.add(radio, con);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = new Dimension(550, 100);
        return d;
    }
}

public class LeftPanel extends JTabbedPane {

    JTabbedPane section1;
    JTabbedPane section2;
    JPanel subsection1;
    JPanel subsection2;

    LeftPanel() {
        section1 = new JTabbedPane();
        section2 = new JTabbedPane();

        subsection1 = new JPanel();
        subsection1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        subsection2 = new JPanel();
        subsection2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        String[] string1 = {"Hello", "goodby"};

        subsection1.add(new QuestionPanel("What is A?", string1));
        subsection1.add(new QuestionPanel("What is B?", string1));

        section1.addTab("Subsection 1", subsection1);
        section1.addTab("Subsection 2", subsection2);

        this.addTab("Section 1", section1);
        this.addTab("Section 2", section2);
    }

    public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers();
        QuestionPaper paper = model.getPaper(0);

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 0));
        frame.setPreferredSize(new Dimension(1200, 800));

        frame.add(new LeftPanel());

        RightPanel panel = new RightPanel(paper);


        //frame.add(new RightPanel(paper));
        //frame.add(new RightPanel(paper.getSection(0)));
        //frame.add(new RightPanel(paper.getSection(0).getSubSection(0)));
        //frame.add(new RightPanel(paper.getSection(0).getSubSection(1).getQuestion(0)));

        frame.add(panel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            frame.remove(panel);
            panel = new RightPanel(paper.getSection(0));
            frame.add(panel);
            frame.revalidate();
            frame.repaint();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            frame.remove(panel);
            panel = new RightPanel(paper.getSection(0).getSubSection(0));
            frame.add(panel);
            frame.revalidate();
            frame.repaint();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            frame.remove(panel);
            panel = new RightPanel(paper.getSection(0).getSubSection(0).getQuestion(0));
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            frame.remove(panel);
            panel = new RightPanel(paper);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();            
        }
    }
}
