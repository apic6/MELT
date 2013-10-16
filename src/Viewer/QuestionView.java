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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
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

    public QuestionView(Question question) {
        // left panel represents the question+answer
        JPanel leftPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = 975;
                return d;
            }
        };
        
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);
        setLayout(mainLayout);

        this.question = new JLabel("<html>" + question.getQuestion() + "</html>", 0);
        this.question.setHorizontalTextPosition(SwingConstants.LEFT);
        this.question.setHorizontalAlignment(SwingConstants.LEFT);
        leftPanel.setAlignmentX(LEFT_ALIGNMENT);
        leftPanel.add(this.question);

        JLabel spacing = new JLabel("\n");
        leftPanel.add(spacing);

        // if FITBQuestion
        if (question instanceof FITBQuestion) {
            answerArea = new JTextArea("Type Answer Here", 1, 50);
            answerArea.setSize(575, 50);
            leftPanel.add(this.answerArea);

        } else if (question instanceof MultipleChoiceQuestion) { // MCQ
            MultipleChoiceQuestion mcqQuestion = (MultipleChoiceQuestion) question;
            group = new ButtonGroup();
            answerOption = new JRadioButton[mcqQuestion.getNumberOfAnswers()];

            for (int i = 0; i < mcqQuestion.getNumberOfAnswers(); i++) {
                answerOption[i] = new JRadioButton(mcqQuestion.getAnswer(i));
                answerOption[i].setMnemonic(KeyEvent.VK_B);
                answerOption[i].setActionCommand(((MultipleChoiceQuestion) question).getAnswer(i));
                group.add(answerOption[i]);
                leftPanel.add(this.answerOption[i]);
            } // for each answer
        } // else MCQ
        // add leftPanel
        this.add(leftPanel);
        // add Button
        JButton submitButton = new JButton("Save");
        this.add(submitButton);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.width = 1025;
        return d;
    }
}