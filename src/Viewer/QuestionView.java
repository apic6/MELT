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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);
        setLayout(mainLayout);



        // if FITBQuestion
        if (question instanceof FITBQuestion) {
            FITBQuestion fitbQ = (FITBQuestion)question;
            String[] questionText = fitbQ.getQuestionParts();
            
            this.question = new JLabel("<html>" + questionText[0] + "  BLANK  " + questionText[1] + "</html>", 0);
            this.question.setHorizontalTextPosition(SwingConstants.LEFT);
            this.question.setHorizontalAlignment(SwingConstants.LEFT);
            leftPanel.setAlignmentX(LEFT_ALIGNMENT);
            leftPanel.add(this.question);

            JLabel spacing = new JLabel("\n");
            
            
            leftPanel.add(spacing);
            answerArea = new JTextArea("Type Answer Here", 1, 50);
            answerArea.setSize(575, 50);
            leftPanel.add(this.answerArea);

        } else if (question instanceof MultipleChoiceQuestion) { // MCQ
            MultipleChoiceQuestion mcQuestion = (MultipleChoiceQuestion)question;
            
            this.question = new JLabel("<html>" + mcQuestion.getQuestion() + "</html>", 0);
            this.question.setHorizontalTextPosition(SwingConstants.LEFT);
            this.question.setHorizontalAlignment(SwingConstants.LEFT);
            leftPanel.setAlignmentX(LEFT_ALIGNMENT);
            leftPanel.add(this.question);

            JLabel spacing = new JLabel("\n");
            
            
            leftPanel.add(spacing);
            MultipleChoiceQuestion mcqQuestion = (MultipleChoiceQuestion) question;
            group = new ButtonGroup();
            answerOption = new JRadioButton[mcqQuestion.getNumberOfAnswers()];

            for (int i = 0; i < mcqQuestion.getNumberOfAnswers(); i++) {
                answerOption[i] = new JRadioButton(mcqQuestion.getAnswer(i));
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
                leftPanel.add(this.answerOption[i]);
            } // for each answer
        } // else MCQ
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