/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package Viewer;

import Model.questionPaper.*;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
*
* @author Daniel
*/
public class SubsectionEditor extends JPanel{
    private Popup pop=new Popup();
    private JLabel title_label = new JLabel("title:");
    private  JTextArea titleArea = new JTextArea(1,30);
    private JLabel description_label = new JLabel("description:");
    private  JTextArea description = new JTextArea(3,30);
    private JLabel instruction_label = new JLabel("instruction:");
    private  JTextArea instruction = new JTextArea(3,30);
    private JLabel markArea;
    static JTextArea answer = new JTextArea(1,20);
    private JTabbedPane questionType;
    private JPanel MCQ;
    static JButton submit;
    SubSection subSection;
    Question question;
    int j=0;
    private JPanel answerPanel;
    GridBagConstraints apc = new GridBagConstraints();
    private JPanel FIBQ;
    private JPanel MFIBQ;
    private JPanel Essay;
    
    JPanel questionCreator = new JPanel() ;
     ArrayList<JTextArea> answerAreas;
     private TestWizard wizard;
     int num_answers;
     Subsection subsectionPanel;
     MultipleChoiceQuestion mcquestion = new MultipleChoiceQuestion();
     
    
    public SubsectionEditor(SubSection subSection, Question Q, TestWizard wizard,Subsection subsectionPanel)
    {
        titleArea.setText(subSection.getTitle());
        description.setText(subSection.getDescription());
        instruction.setText(subSection.getInstructions());
        answerAreas = new ArrayList();
        this.wizard = wizard;
        this.subSection = subSection;
        this.subsectionPanel = subsectionPanel;
        if(Q != null){
        question = Q;
        if (question instanceof MultipleChoiceQuestion) {
            mcquestion = (MultipleChoiceQuestion)question;
        } else {
            mcquestion = null;
        }
        }
        initComponents();
    }
    
    private void initComponents() {
        
       
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,5,10);
        add(title_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.weighty=1.0;
        gbc.gridx = 1;
        add(titleArea,gbc);
        
        titleArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                subSection.setTitle(titleArea.getText());
                ((JTabbedPane)subsectionPanel.getParent()).setTitleAt(((JTabbedPane)subsectionPanel.getParent()).getSelectedIndex(),titleArea.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                subSection.setTitle(titleArea.getText());
                ((JTabbedPane)subsectionPanel.getParent()).setTitleAt(((JTabbedPane)subsectionPanel.getParent()).getSelectedIndex(),titleArea.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                subSection.setTitle(titleArea.getText());
                ((JTabbedPane)subsectionPanel.getParent()).setTitleAt(((JTabbedPane)subsectionPanel.getParent()).getSelectedIndex(),titleArea.getText());
            }
    });
        
        gbc.weightx = 0.3;
        gbc.weighty=1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(description_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(description,gbc);
        
        description.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                subSection.setDescription(description.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                subSection.setDescription(description.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                subSection.setDescription(description.getText());
            }
    });
        
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(instruction_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(instruction,gbc);
        
        instruction.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                subSection.setInstructions(instruction.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                subSection.setInstructions(instruction.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                subSection.setInstructions(instruction.getText());
            }
    });
        
        questionCreator = renderQuestionCreator(question);

        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy = 3;
        add(questionCreator,gbc);
    }
    
        public JPanel addAnswer(final int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+num+": ");
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
            
            final JTextArea answer_new = new JTextArea(1,20);
            if(mcquestion.getAnswers() == null){
                mcquestion.setAnswers(new String[1]);
                mcquestion.setPossibleAnswers(new int[1]);
            }else{
                String[] new_answers = new String[mcquestion.getNumberOfAnswers()+1];
                System.arraycopy(mcquestion.getAnswers(),0,new_answers,0,mcquestion.getNumberOfAnswers());
                mcquestion.setAnswers(new_answers);
                int[] new_possibles = new int[mcquestion.getNumberOfPossibleAnswers()+1];
                System.arraycopy(mcquestion.getPossibleAnswers(),0,new_possibles,0,mcquestion.getNumberOfPossibleAnswers());
                mcquestion.setPossibleAnswers(new_possibles);
            }
                
            answer_new.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mcquestion.getAnswers()[num-1] = answer_new.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mcquestion.getAnswers()[num-1] = answer_new.getText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                mcquestion.getAnswers()[num-1] = answer_new.getText();
            }
    });
            answerAreas.add(answer_new);
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(answer_new,gbc);
            JCheckBox isRight = new JCheckBox("right answer");
            isRight.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    mcquestion.getPossibleAnswers()[num-1] = e.getStateChange()==ItemEvent.SELECTED?1:0;
                }
            });
            gbc.weightx = 0;
            gbc.gridx = 2;
            tempPanel.add(isRight,gbc);
            return tempPanel;
            
            
        }
        
        private JPanel renderQuestionCreator(Question question){
            JPanel tempCreator = new JPanel();
            tempCreator.setLayout(new GridBagLayout());
            if(question != null)
                tempCreator.setBorder(new TitledBorder("Edit Question"));
            else
                tempCreator.setBorder(new TitledBorder("Create New Question"));
            final GridBagConstraints c3 = new GridBagConstraints();

            questionType = new JTabbedPane();
            MCQ = new JPanel();
            MCQ.setLayout(new GridBagLayout());
            c3.fill = GridBagConstraints.BOTH;
            c3.insets = new Insets(10,5,5,10);
            c3.weightx = 0.3;
            c3.gridx = 0;
            c3.gridy = 0;
            JLabel title_label2 = new JLabel("title: ");
            MCQ.add(title_label2,c3);

            c3.gridx = 1;
            c3.weightx = 0.7;
            titleArea = new JTextArea(1,20);
            
            titleArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mcquestion.setQuestion(titleArea.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mcquestion.setQuestion(titleArea.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                 mcquestion.setQuestion(titleArea.getText());
            }
    });
                
            MCQ.add(titleArea,c3);

            JPanel markPane = new JPanel() ;
            markPane.setLayout(new GridBagLayout());
            GridBagConstraints c4 = new GridBagConstraints();
            JLabel mark_label = new JLabel("marks: ");
            c4.gridy = 0;
            c4.gridx = 0;
            c4.weightx = 0;
            markPane.add(mark_label,c4);
            
           
            c4.gridx = 1;
            c4.weightx = 0.3;
            markArea = new JLabel();
            markPane.add(markArea,c4);
            
            c4.gridx++;
             JButton moreTime = new JButton("+");
            moreTime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                markArea.setText(String.valueOf(Integer.parseInt(markArea.getText())+1));
                mcquestion.setMark(Integer.parseInt(markArea.getText())+1);
            }
        });
            JButton lessTime = new JButton("-");
      lessTime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(markArea.getText())>0){
                markArea.setText(String.valueOf(Integer.parseInt(markArea.getText())-1));
                mcquestion.setMark(Integer.parseInt(markArea.getText())+1);
                }
            }
        });
            markPane.add(moreTime,c4);
      c4.gridx++;
      markPane.add(lessTime,c4);
      c3.gridx = 0 ;
      c3.gridy = 1 ;
      c3.weightx = 1 ;
      c3.weighty = 1 ;
      c3.gridwidth = GridBagConstraints.RELATIVE ;
     c3.fill = GridBagConstraints.BOTH;
      MCQ.add(markPane, c3) ;
            
            JButton addAnswer = new JButton("add answer");
            c3.gridx = 2;
            c3.weightx = 0.2;
            MCQ.add(addAnswer,c3);

            answerPanel = new JPanel();
            c3.gridx = 0;
            c3.gridwidth = GridBagConstraints.REMAINDER;
            c3.gridy = 2;
            c3.weighty = 1.0;
            c3.weightx = 1.0;
            MCQ.add(answerPanel,c3);

            JButton submit = new JButton("submit");
            
            
            
            c3.gridx = 0;
            c3.gridy = 3;
            c3.weighty = 0.2;
            c3.ipady = 20 ;
            MCQ.add(submit,c3);

            answerPanel.setLayout(new GridBagLayout());
            apc.gridx = 0;
            apc.gridy = 0;
            
            if(question != null){
            titleArea.setText(question.getQuestion());
            markArea.setText(String.valueOf(mcquestion.getMark()));
            for (int i = 0 ; i < mcquestion.getNumberOfAnswers(); i++)
            {
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+(i+1)+": ");
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc1 = new GridBagConstraints();
            gbc1.gridx = 0;
            gbc1.weightx = 0.3;
            tempPanel.add(answer_label,gbc1);
            answer = new JTextArea(1,20);
            answer.setText(mcquestion.getAnswer(i));
            answer.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                for(int j = 0;j<answerAreas.size();++j)
                (mcquestion.getAnswers())[j] = answerAreas.get(j).getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                for(int j = 0;j<answerAreas.size();++j)
                (mcquestion.getAnswers())[j] = answerAreas.get(j).getText();            
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                for(int j = 0;j<answerAreas.size();++j)
                (mcquestion.getAnswers())[j] = answerAreas.get(j).getText();            
            }
    });
            answerAreas.add(answer);
            gbc1.gridx = 1;
            gbc1.weightx = 0.7;
            tempPanel.add(answer,gbc1);
            JCheckBox isRight = new JCheckBox("right answer");
            
            if (mcquestion.getPossibleAnswer(i) == 1) {
            
                isRight.setSelected(true);
                
            }
            gbc1.gridx = 2;
            tempPanel.add(isRight,gbc1.gridy);
            apc.weightx = 1.0;
            answerPanel.add(tempPanel,apc);
            apc.gridy++;
            }
            answerPanel.revalidate();
            answerPanel.repaint();
            
            submit.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
            mcquestion.setMark(Integer.parseInt(markArea.getText()));
            subSection.addQuestion(mcquestion);
            //revalidate();
            }
 });
            }
            else{
            markArea.setText("0");
            submit.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                if (mcquestion.getNumberOfAnswers()>1&&mcquestion.getRightAnswers()>0){
                    mcquestion.setMark(Integer.parseInt(markArea.getText()));
                    subSection.addQuestion(mcquestion);
                    //revalidate();
                    subsectionPanel.listModel.addElement(mcquestion.getQuestion());
                   }
                else if(mcquestion.getNumberOfAnswers()<=1){pop.setText("You should create two or more answers!");pop.show();}
                else{pop.setText("Question should have at least one right answer!");pop.show();}
           }
 });
            }
            addAnswer.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    apc.gridy++;
                    apc.weightx = 1.0;
                    answerPanel.add(addAnswer(++num_answers),apc);
                    answerPanel.revalidate();
                    answerPanel.repaint();
                }

            });
            questionType.addTab("MCQ",MCQ);

            FIBQ = new JPanel();
            questionType.addTab("FIBQ",FIBQ);
            tempCreator.add(questionType);
            return tempCreator;
        }
        
        public static void addListeners(FocusListener foc){
    //might be useful in the future
        }
}
