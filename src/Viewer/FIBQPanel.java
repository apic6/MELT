/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.questionPaper.FITBQuestion ;
import Model.questionPaper.Question;
import Model.questionPaper.SubSection;
import static Viewer.SubsectionEditor.answer;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author mbaxkak4
 */
public final class FIBQPanel extends JPanel {
    private JFrame mainFrame;
    private Popup pop=new Popup();
       private JTabbedPane questionType;
    JTextField firstPart=new JTextField(10);
    JTextField secondPart=new JTextField(10);
    private Modeller model;
    JLabel markArea = new JLabel("0") ;
    GridBagConstraints apc = new GridBagConstraints();
    GridBagConstraints c = new GridBagConstraints();
    FITBQuestion fibquestion = new FITBQuestion();
    int j=0;
    ArrayList<JTextArea> answerAreas ;
    int num_answers;
    Subsection subsectionPanel;
    private final SubSection subSection;
    Question question;
   //public FIBQPanel (JFrame frame,Modeller model) {
    public FIBQPanel (SubSection subSection, Question Q, Subsection subsectionPanel, JTabbedPane questionType) { 
        this.subSection = subSection;
        this.subsectionPanel = subsectionPanel;
        this.questionType = questionType;
        
        answerAreas = new ArrayList();
        if (Q != null)
        {
            question = Q ;
            if (question instanceof FITBQuestion)
                fibquestion = (FITBQuestion)question ;
        }
      //  this.model=model;
      //  this.mainFrame=frame;
        initComponents();
}
  
   
   void initComponents() {
      
            questionType.addTab("FIBQ",this);
//       
       if (fibquestion.getQuestionParts() == null){
           fibquestion.setQuestionParts(new String[2]);
           fibquestion.setPossibleAnswers(new String[0]);
          
       }
       
       setLayout(new GridBagLayout()) ; 
     // c.ipady=10;
       //c.fill = GridBagConstraints.BOTH ;
      c.anchor = GridBagConstraints.NORTH;
      //c.weighty=1.0;
      c.gridx=0;
      c.gridy=0;
      JLabel title=new JLabel("Sentence");
      this.add(title,c);
      c.gridx=1;
      c.gridy=0;
      c.ipadx = 200 ;
      this.add(firstPart,c);
      firstPart.getDocument().addDocumentListener(new DocumentListener (){
       @Override
            public void insertUpdate(DocumentEvent e) {
                fibquestion.setQuestionParts(firstPart.getText(), 0);
            }
       
            @Override
            public void removeUpdate(DocumentEvent e) {
                fibquestion.setQuestionParts(firstPart.getText(), 0);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                 fibquestion.setQuestionParts(firstPart.getText(), 0);
            }
   });
      c.ipadx = 0 ;
      c.gridx=0;
      c.gridy=1;
      JLabel blank=new JLabel("Blank");
      this.add(blank,c);
      c.ipadx = 200 ;
      c.gridx=1;
      c.gridy=1;
      
      this.add(secondPart,c);
      secondPart.getDocument().addDocumentListener(new DocumentListener (){
       @Override
            public void insertUpdate(DocumentEvent e) {
                fibquestion.setQuestionParts(secondPart.getText(), 1);
            }
       
            @Override
            public void removeUpdate(DocumentEvent e) {
                fibquestion.setQuestionParts(secondPart.getText(), 1);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                 fibquestion.setQuestionParts(secondPart.getText(), 1);
            }
   });
      
      JPanel markPane = new JPanel();
      markPane.setLayout(new GridBagLayout());
      GridBagConstraints c4 = new GridBagConstraints();
      JLabel markLabel = new JLabel("marks: ");
      
      c4.gridx = 0;
      c4.gridx = 0;
            c4.weightx = 0;
            markPane.add(markLabel,c4);
            
           
            c4.gridx = 1;
            c4.weightx = 0.3;
            
            markPane.add(markArea,c4);
            
            c4.gridx++;
             JButton moreTime = new JButton("+");
            moreTime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                markArea.setText(String.valueOf(Integer.parseInt(markArea.getText())+1));
                fibquestion.setMark(Integer.parseInt(markArea.getText())+1);
            }
        });
            JButton lessTime = new JButton("-");
      lessTime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(markArea.getText())>0){
                markArea.setText(String.valueOf(Integer.parseInt(markArea.getText())-1));
                fibquestion.setMark(Integer.parseInt(markArea.getText())+1);
                }
            }
        });
            markPane.add(moreTime,c4);
      c4.gridx++;
      markPane.add(lessTime,c4);
      
      c.ipadx = 0 ;
      c.gridx=0;
      c.gridy=2;
      c.ipady = 0 ;
      c.weighty = 1.0 ;
      c.weightx = 1.0 ;
//      c.ipady = 10 ;
      c.anchor = GridBagConstraints.FIRST_LINE_START;
      //c.weighty = 2 ;
      
      JButton addAnswerButton=new JButton("Add Answer");
      //c.gridwidth = GridBagConstraints.REMAINDER ;
      c.fill = GridBagConstraints.HORIZONTAL ;
      
      this.add(markPane,c);
      apc.gridx = 0;
      apc.gridy = 0;
      
      c.gridx=1;
      c.gridy=2;
      c.ipady = 0 ;
      c.weighty = 1.0 ;
      c.weightx = 1.0 ;
//      c.ipady = 10 ;
      c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridwidth = GridBagConstraints.REMAINDER ;
      this.add(addAnswerButton, c);
      //c.ipady = 0 ;
      final JPanel answerPanel = new JPanel();
      answerPanel.setLayout(new GridBagLayout());
      
      c.gridx = 0 ;
      c.gridy=3;
    
      this.add(answerPanel, c) ;
      
       JButton submit = new JButton("submit");
       c.gridx = 0 ;
       c.ipady = 20 ;
       c.gridy = 4 ;
       c.fill = GridBagConstraints.HORIZONTAL;
       c.anchor = GridBagConstraints.PAGE_END ;
       this.add(submit, c);
      
       
       
       
       
       if(question!= null){
                questionType.setSelectedComponent(this);
//                titleArea.setText(mcquestion.getQuestion());
           firstPart.setText(fibquestion.getQuestionParts()[0]);
           secondPart.setText(fibquestion.getQuestionParts()[1]);
                markArea.setText(String.valueOf(fibquestion.getMark()));
                
                for (int i = 0 ; i < fibquestion.getNumberOfPossibleAnswers(); i++)
                {
                JPanel tempPanel = new JPanel();
                JLabel answer_label = new JLabel("answer"+(i+1)+": ");
                tempPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc1 = new GridBagConstraints();
                gbc1.gridx = 0;
                gbc1.weightx = 0.3;
                tempPanel.add(answer_label,gbc1);
                answer = new JTextArea(1,20);
                answer.setText(fibquestion.getPossibleAnswer(i));
                answer.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    for(int j = 0;j<answerAreas.size();++j)
                    (fibquestion.getPossibleAnswers()[j]) = answerAreas.get(j).getText();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    for(int j = 0;j<answerAreas.size();++j)
                   (fibquestion.getPossibleAnswers()[j]) = answerAreas.get(j).getText();         
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    for(int j = 0;j<answerAreas.size();++j)
                    (fibquestion.getPossibleAnswers()[j]) = answerAreas.get(j).getText();          
                }
                });
                answerAreas.add(answer);
                gbc1.gridx = 1;
                gbc1.weightx = 0.7;
                tempPanel.add(answer,gbc1);
                
//                apc.weightx = 1.0 ;
               
                answerPanel.add(tempPanel, apc);
                apc.gridy++ ;
                }
                answerPanel.revalidate();
                answerPanel.repaint();

                submit.addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e){
            
                fibquestion.setMark(Integer.parseInt(markArea.getText()));
                subSection.addQuestion(fibquestion);
                subsectionPanel.questionList.clearSelection();
                
                
                
//                subsectionPanel.listModel.addElement(fibquestion.getQuestion());
                
                }
                });
                
                
                }
                else{
                
                markArea.setText("0");
                
                
                submit.addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e){
                        if (fibquestion.getQuestionParts()[0] != null && fibquestion.getQuestionParts()[1] != null){
                    fibquestion.setMark(Integer.parseInt(markArea.getText()));
                    subSection.addQuestion(fibquestion);
                    subsectionPanel.listModel.addElement(fibquestion.getQuestion());
               subsectionPanel.questionList.clearSelection();
                    }
                       
                else{pop.setText("Need the question!");pop.show();}
               }
                });
                
                
            }
       if(fibquestion.getNumberOfPossibleAnswers() == 0)
                num_answers = 0;
            else
                num_answers = fibquestion.getNumberOfPossibleAnswers();
       addAnswerButton.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              apc.gridy++;
              
          answerPanel.add(addAnswer(++num_answers),apc);
          revalidate();
          repaint();
          
          
          
          }
      });
       
       
       
       
       
//       submit.addActionListener(new ActionListener (){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                if (fibquestion.getQuestion() != null){
//                    subsectionPanel.listModel.addElement(fibquestion.getQuestion());
//                }
//                fibquestion.setMark(Integer.parseInt(markArea.getText()));
//                subSection.addQuestion(fibquestion);
////                subsectionPanel.listModel.addElement(fibquestion.getQuestion());
//                
//                
//               
//            }
//       });
   }

   public JPanel addAnswer(final int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+num+": ");
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5,0,0,0);
            gbc.anchor= GridBagConstraints.FIRST_LINE_START ;
            gbc.weighty=1.0;
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
            final JTextArea newAnswer = new JTextArea(1, 20);
//            this.add(newAnswer);
            if (fibquestion.getPossibleAnswers() == null) {
               fibquestion.setPossibleAnswers(new String [1]);
            }
            else
            {
                String[] new_answers = new String[fibquestion.getNumberOfPossibleAnswers()+1];
                System.arraycopy(fibquestion.getPossibleAnswers(),0,new_answers,0,fibquestion.getNumberOfPossibleAnswers());
                fibquestion.setPossibleAnswers(new_answers);
                }
            newAnswer.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fibquestion.getPossibleAnswers()[num-1] = newAnswer.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fibquestion.getPossibleAnswers()[num-1] = newAnswer.getText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                fibquestion.getPossibleAnswers()[num-1] = newAnswer.getText();
            }
    });
            answerAreas.add(newAnswer) ;
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(newAnswer,gbc);
            return tempPanel;
            
        }
   public static void main(String argv[]) {
       JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 0));
        //frame.setPreferredSize(new Dimension(1200, 800));

        //frame.add(new FIBQPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
   }
}