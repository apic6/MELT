/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.MultipleChoiceQuestion;
import Model.SubSection;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel
 */
public class QuestionCreator extends JFrame{
    JCheckBox isRight = new JCheckBox("right answer");
    JTextArea answer = new JTextArea(1,20);
    JTabbedPane questionType;
    JPanel MCQ;
    JPanel FIBQ;
    JPanel mainPane;
    JPanel answerPanel;
    JTextArea title;
    ArrayList<JTextArea> answerAreas;
    GridBagConstraints gbc_parent;
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints apc = new GridBagConstraints();
    
    MultipleChoiceQuestion question;
    SubSection subSection;
    public QuestionCreator(JPanel mainPane,GridBagConstraints gbc_parent,SubSection subSection){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mainPane = mainPane;
        this.gbc_parent = gbc_parent;
        answerAreas = new ArrayList();
        this.subSection = subSection;
        initComponents();
    }
    
    private void initComponents() {
        questionType = new JTabbedPane();
        MCQ = new JPanel();
        MCQ.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel title_label = new JLabel("title:  ");
        MCQ.add(title_label,gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        title = new JTextArea(1,20);
        MCQ.add(title,gbc);
        
        JButton addAnswer = new JButton("add answer");
        gbc.gridx = 2;
        gbc.weightx = 0;
        MCQ.add(addAnswer,gbc);
        
        answerPanel = new JPanel();
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        MCQ.add(answerPanel,gbc);
        
        JButton submit = new JButton("submit");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        MCQ.add(submit,gbc);
        
        submit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gbc_parent.gridy++;
                JLabel question_des = new JLabel(title.getText());
                mainPane.add(question_des,gbc_parent);
                String[] answers = new String[10];
                
                for(int i =0; i< answerAreas.size();++i){
                    answers[i] = answerAreas.get(i).getText();
                }
                // TODO: make it so that there is a fourth argument that is an array of integers which corresponds to the correct answers
                question = new MultipleChoiceQuestion(title.getText(),answers,"None" /* instructions */, null /* poss. answers */, 0 /* marks */);
                subSection.addQuestion(question);
                mainPane.revalidate();
            }
        
        });
        
        answerPanel.setLayout(new GridBagLayout());
        apc.gridx = 0;
        apc.gridy = -1;
        
        addAnswer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apc.gridy++;
                apc.weightx = 1.0;
                answerPanel.add(addAnswer(apc.gridy+1),apc);
                answerPanel.revalidate();
            }
        
        });
        
        questionType.addTab("MCQ",MCQ);
        
        FIBQ = new JPanel();
        questionType.addTab("FIBQ",FIBQ);
        
        add(questionType);
        this.setPreferredSize(new Dimension(500,500));
        pack();
    }
    
        public JPanel addAnswer(int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+num);
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
           // JTextArea answer = new JTextArea(1,20);
            answerAreas.add(answer);
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(answer,gbc);
            //JCheckBox isRight = new JCheckBox("right answer");
            gbc.gridx = 2;
            tempPanel.add(isRight,gbc);
            return tempPanel;
        }
    
 public void addListeners(FocusListener foc,ActionListener mal){
 answer.addFocusListener(foc);
 title.addFocusListener(foc);
 isRight.addActionListener(mal);
 
 }   
}
