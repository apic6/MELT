/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.MultipleChoiceQuestion;
import Model.Question;
import javax.swing.JPanel;
import Model.SubSection;
import static Viewer.QuestionCreator.title;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
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
    
    private JLabel title_label = new JLabel("title:");
    private JTextArea titleArea = new JTextArea(1,30);
    private JLabel description_label = new JLabel("description:");
    private JTextArea description = new JTextArea(3,30);
    private JLabel instruction_label = new JLabel("instruction:");
    private JTextArea instruction = new JTextArea(3,30);
    private JTabbedPane questionType;
    private JPanel MCQ;
    private int notEmptyQuetion = 0 ;
    private JPanel rightPanel = new JPanel();
    SubSection subSection;
    Question question;
   
    private JPanel answerPanel;
    GridBagConstraints apc = new GridBagConstraints();
    private JPanel FIBQ;
    final JPanel questionCreator = new JPanel() ;
     ArrayList<JTextArea> answerAreas;
     private TestWizard wizard;
     
     
    public SubsectionEditor(SubSection subSection,TestWizard wizard){
        titleArea.setText(subSection.getTitle());
        description.setText(subSection.getDescription());
        instruction.setText(subSection.getInstructions());
        answerAreas = new ArrayList();
        this.subSection = subSection;
        this.wizard = wizard;
        initComponents();
    }
    
    public SubsectionEditor(SubSection subSection, Question Q, TestWizard wizard)
    {
        title.setText(subSection.getTitle());
        description.setText(subSection.getDescription());
        instruction.setText(subSection.getInstructions());
        answerAreas = new ArrayList();
        question = Q;
        notEmptyQuetion = 1 ;
        this.wizard = wizard;
        initComponentsQ();
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
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                subSection.setTitle(titleArea.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                subSection.setTitle(titleArea.getText());
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
        
            questionCreator.setLayout(new GridBagLayout());
            questionCreator.setBorder(new TitledBorder("Create New Question"));
            final GridBagConstraints c3 = new GridBagConstraints();

            //questionCreator.setBackground(Color.red);

            questionType = new JTabbedPane();
            MCQ = new JPanel();
            MCQ.setLayout(new GridBagLayout());
            c3.fill = GridBagConstraints.BOTH;
            c3.insets = new Insets(10,5,5,10);
            c3.weightx = 0.3;
            c3.gridx = 0;
            c3.gridy = 0;
            JLabel title_label = new JLabel("title:  ");
            MCQ.add(title_label,c3);

//            questionType.add(MCQ, c3) ;

            c3.gridx = 1;
            c3.weightx = 0.7;
            title = new JTextArea(1,20);
            MCQ.add(title,c3);

            JLabel mark_label = new JLabel("marks");
            c3.gridy = 1;
            c3.gridx = 0;
            c3.weightx = 0.5;
            MCQ.add(mark_label,c3);
            
            JTextArea markArea = new JTextArea(1,5);
            c3.gridx = 1;
            c3.weightx = 0.3;
            MCQ.add(markArea,c3);
            
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
//            questionType.setPreferredSize(questionCreator.getSize());
            questionCreator.add(questionType);

        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy = 3;
        add(questionCreator,gbc);
    }
    private void initComponentsQ() {
        
        MultipleChoiceQuestion mcquestion = question.getMCQ() ;
        
        
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
        add(title,gbc);
        
        gbc.weightx = 0.3;
        gbc.weighty=1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(description_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(description,gbc);
        
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(instruction_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(instruction,gbc);
        
            questionCreator.setLayout(new GridBagLayout());
            questionCreator.setBorder(new TitledBorder("Create New Question"));
            final GridBagConstraints c3 = new GridBagConstraints();

            //questionCreator.setBackground(Color.red);

            questionType = new JTabbedPane();
            MCQ = new JPanel();
            MCQ.setLayout(new GridBagLayout());
            c3.fill = GridBagConstraints.BOTH;
            c3.insets = new Insets(10,5,5,10);
            c3.weightx = 0.3;
            c3.gridx = 0;
            c3.gridy = 0;
            JLabel title_label = new JLabel("title:  ");
            MCQ.add(title_label,c3);

//            questionType.add(MCQ, c3) ;

            c3.gridx = 1;
            c3.weightx = 0.7;
            title = new JTextArea(1,20);
            
            title.setText(question.getQuestion());
            
            MCQ.add(title,c3);

            JLabel mark_label = new JLabel("marks");
            c3.gridy = 1;
            c3.gridx = 0;
            c3.weightx = 0.5;
            
            MCQ.add(mark_label,c3);
            
            JTextArea markArea = new JTextArea(1,5);
            
            c3.gridx = 1;
            c3.weightx = 0.3;
            markArea.setText(Integer.toString(mcquestion.getMark()));
            MCQ.add(markArea,c3);
            
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
            apc.gridy = -1;

            for (int i = 0 ; i < mcquestion.getNumberOfAnswers(); i++)
            {
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+i+":  ");
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc1 = new GridBagConstraints();
            gbc1.gridx = 0;
            gbc1.weightx = 0.3;
            tempPanel.add(answer_label,gbc1);
            JTextArea answer = new JTextArea(1,20);
            answer.setText(mcquestion.getAnswer(i));
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
            apc.gridy++;
            apc.weightx = 1.0;
            answerPanel.add(tempPanel,apc);
            answerPanel.revalidate();
            }
            
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
//            questionType.setPreferredSize(questionCreator.getSize());
            questionCreator.add(questionType);

        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy = 3;
        add(questionCreator,gbc);
    }
        public JPanel addAnswer(int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+num+":  ");
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
            JTextArea answer = new JTextArea(1,20);
            answerAreas.add(answer);
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(answer,gbc);
            JCheckBox isRight = new JCheckBox("right answer");
            gbc.gridx = 2;
            tempPanel.add(isRight,gbc); 
            return tempPanel;
            
            
        }
}
