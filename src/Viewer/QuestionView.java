/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Model.*;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author mbgm8je3
 */
public class QuestionView extends JPanel {

    JLabel question;
    ButtonGroup group;
    JTextArea answerArea;
    JRadioButton[] answerOption;

    public QuestionView(Question question, final QuestionPaperTaker taker, final int sectionID, final int subSectionID, final int questionID) {
        // left panel represents the question+answer
        JPanel leftPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = 1000;
                return d;
            }
        };

        leftPanel.setLayout(new GridBagLayout());

        FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.NORTHWEST;
        // con.fill = GridBagConstraints.HORIZONTAL;
        setLayout(mainLayout);



        // if FITBQuestion
        if (question instanceof FITBQuestion) {

            FITBQuestion fitbQ = (FITBQuestion) question;
            String[] questionText = fitbQ.getQuestionParts();

            this.question = new JLabel("<html>" + questionText[0] + "  ________  " + questionText[1] + "</html>", 0);
            leftPanel.add(this.question, con);
            con.gridy++;

            JLabel spacing = new JLabel("\n");


            leftPanel.add(spacing, con);
            con.gridy++;
            answerArea = new JTextArea("Type Answer Here", 1, 50) {
                @Override
                public Dimension getPreferredSize() {
                    Dimension d = super.getPreferredSize();
                    d.width = 1000;
                    return d;
                }
            };
            answerArea.setSize(575, 50);
            leftPanel.add(this.answerArea, con);

        } else if (question instanceof MultipleChoiceQuestion) { // MCQ
            MultipleChoiceQuestion mcQuestion = (MultipleChoiceQuestion) question;

            this.question = new JLabel("<html>" + mcQuestion.getQuestion() + "</html>", 0);
            leftPanel.add(this.question, con);
            con.gridy++;

            JLabel spacing = new JLabel("\n");
            leftPanel.add(spacing, con);
            con.gridy++;

            MultipleChoiceQuestion mcqQuestion = (MultipleChoiceQuestion) question;
            group = new ButtonGroup();
            answerOption = new JRadioButton[mcqQuestion.getNumberOfAnswers()];


            for (int i = 0; i < mcqQuestion.getNumberOfAnswers(); i++) {
                answerOption[i] = new JRadioButton(mcqQuestion.getAnswer(i)) {
                    @Override
                    public Dimension getPreferredSize() {
                        Dimension d = super.getPreferredSize();
                        d.width = 1000;
                        return d;
                    }
                };
                answerOption[i].setMnemonic(i);
                answerOption[i].setActionCommand(((MultipleChoiceQuestion) question).getAnswer(i));
                final int j = i;
                answerOption[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        taker.answerQuestion(sectionID, subSectionID, questionID, group.getSelection().getMnemonic());
                    }
                });
                group.add(answerOption[i]);
                leftPanel.add(this.answerOption[i], con);
                con.gridy++;
            } // for each answer 
        } else if (question instanceof MBQuestion) {
            MBQuestion mfibQuestion = (MBQuestion) question;
            ArrayList<String> questionParts = mfibQuestion.getQuestionParts();

            String text = "<html>";
            for (int i = 0; i < questionParts.size() - 1; i++) {
                text += questionParts.get(i);
                text += " ________(";
                text += (i + 1);
                text += ") ";
            }
            text += questionParts.get(questionParts.size() - 1);
            text += "</html>";

            this.question = new JLabel(text, 0);
            leftPanel.add(this.question, con);
            con.gridy++;

            JLabel spacing = new JLabel("\n");

            leftPanel.add(spacing, con);
            con.gridy++;

            for (int i = 0; i < questionParts.size() - 1; i++) {
                JPanel answerPanel = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        Dimension d = super.getPreferredSize();
                        d.width = 1000;
                        return d;
                    }
                };
                answerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel label = new JLabel("Word " + (i + 1) + ": ");
                JTextArea area = new JTextArea("Type answer here", 1, 50);
                answerPanel.add(label);
                answerPanel.add(area);
                leftPanel.add(answerPanel, con);
                con.gridy++;
            }
        } else if (question instanceof EssayQuestion) {
            EssayQuestion eQuestion = (EssayQuestion) question;
            
            this.question = new JLabel("<html>" + eQuestion.getQuestion() + "</html>", 0);
            leftPanel.add(this.question, con);
            con.gridy++;

            JLabel spacing = new JLabel("\n");
            leftPanel.add(spacing, con);
            con.gridy++;
            
            answerArea = new JTextArea("Type Answer Here");
            answerArea.setLineWrap(true);
            answerArea.setWrapStyleWord(true);
            
            JScrollPane scrollPane = new JScrollPane() {
                @Override
                public Dimension getPreferredSize() {
                    Dimension d = super.getPreferredSize();
                    d.width = 1000;
                    d.height = 140;
                    return d;
                }
            };
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setViewportView(answerArea);
            leftPanel.add(scrollPane, con);            
        }
        // add leftPanel
        this.add(leftPanel);
        // add Button
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.width = 1025;
        return d;
    }
}