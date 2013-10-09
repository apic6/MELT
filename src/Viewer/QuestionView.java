/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        JPanel leftPanel = new JPanel ();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);
        setLayout(mainLayout);

        leftPanel.setPreferredSize(new Dimension (600, 250));
        // leftPanel.setSize(400, 500);                
        
        
        this.question = new JLabel("<html>"+ question.getQuestion() +"</html>", 0);
        this.question.setHorizontalTextPosition(SwingConstants.LEFT);
        this.question.setHorizontalAlignment(SwingConstants.LEFT);
        
        leftPanel.add(this.question);
        leftPanel.add(new JLabel(" "));
        
        
        if (question instanceof FITBQuestion ) {
            answerArea = new JTextArea("Type Answer Here", 1, 80);
            leftPanel.add(this.answerArea);
        } else if (question instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion mcqQuestion = (MultipleChoiceQuestion)question;
            group = new ButtonGroup();
            answerOption = new JRadioButton[mcqQuestion.GetNumberOfAnswers()];
            
            for (int i = 0; i<mcqQuestion.GetNumberOfAnswers(); i++) {
                answerOption[i] = new JRadioButton(mcqQuestion.GetAnswer(i));
                answerOption[i].setMnemonic(KeyEvent.VK_B);
                answerOption[i].setActionCommand(((MultipleChoiceQuestion)question).GetAnswer(i));
                group.add(answerOption[i]);
                leftPanel.add (this.answerOption[i]);
            }
        }
        

        this.add(leftPanel);
        JButton submitButton = new JButton("Submit");
        submitButton.setSize(50, 20);
        this.add(submitButton);
        this.setSize(new Dimension(700, 250));    
   }
    
    public static void main(String argv[]) {
        Modeller model = new Modeller();
        model.loadPapers("src/Papers.xml");
        ArrayList<QuestionPaper> papers = model.getPapersByStudentID(12301230);
        QuestionPaper paper = papers.get(0);
        Section section = paper.GetSection(0);
        SubSection subSection = section.GetSubSection(0);
        Question question = subSection.GetQuestion(0);
        // QuestionView view = new QuestionView(question);
        // view.setVisible(true);
        new QuestionView(question).setVisible(true);
        
    }
}