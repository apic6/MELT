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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    JTextField firstPart=new JTextField(10);
    JTextField secondPart=new JTextField(10);
    private Modeller model;
    JLabel markArea = new JLabel("0") ;
    GridBagConstraints c = new GridBagConstraints();
    FITBQuestion fibquestion = new FITBQuestion();
    int j=0;
    ArrayList<JTextArea> answerAreas ;
    Subsection subsectionPanel;
    private final SubSection subSection;
    Question question;
   //public FIBQPanel (JFrame frame,Modeller model) {
    public FIBQPanel (SubSection subSection, Question Q, Subsection subsectionPanel) { 
        this.subSection = subSection;
        this.subsectionPanel = subsectionPanel;
        
        
        answerAreas = new ArrayList();
        if (Q != null)
        {
            question = Q ;
           // if (question instanceof )
        }
      //  this.model=model;
      //  this.mainFrame=frame;
        initComponents();
}
  
   
   void initComponents() {
      
       
       if (fibquestion.getQuestionParts() == null){
           fibquestion.setQuestionParts(new String[2]);
          
          
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
      c.gridx=2;
      c.gridy=0;
      JLabel blank=new JLabel("Blank");
      this.add(blank,c);
      c.gridx=3;
      c.gridy=0;
      
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
      
      
      c.gridx=0;
      c.gridy=1;
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
      
      c.gridx=1;
      c.gridy=1;
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
      c.gridy=2;
    
      this.add(answerPanel, c) ;
      addAnswerButton.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              c.gridy=j;
          answerPanel.add(addAnswer(j),c);
          revalidate();
          repaint();
          j++;
          
          
          }
      });
       JButton submit = new JButton("submit");
       c.gridx = 0 ;
       c.ipady = 20 ;
       c.gridy = 3 ;
       c.fill = GridBagConstraints.HORIZONTAL;
       this.add(submit, c);
      
       
       
       
       
       if(fibquestion.getQuestionParts()!= null){
//                questionType.setSelectedIndex(0);
//                titleArea.setText(mcquestion.getQuestion());
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
                
                
                
                }
                answerPanel.revalidate();
                answerPanel.repaint();

                submit.addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e){
                fibquestion.setMark(Integer.parseInt(markArea.getText()));
                subSection.addQuestion(fibquestion);
                //revalidate();
                }
                });
                }
                else{
                
                markArea.setText("0");
                submit.addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e){
                fibquestion.setMark(Integer.parseInt(markArea.getText()));
                subSection.addQuestion(fibquestion);
                subsectionPanel.listModel.addElement(fibquestion.getQuestion());
               }
                });
            }
       
       
       
       
       
       submit.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                fibquestion.setMark(Integer.parseInt(markArea.getText()));
                subSection.addQuestion(fibquestion);
                subsectionPanel.listModel.addElement(fibquestion.getQuestion());
                
                
                System.out.println(fibquestion.getQuestionParts()[0] + "_\n"); 
                System.out.println(fibquestion.getQuestionParts()[1] + "_\n"); 
                System.out.println(fibquestion.getPossibleAnswer(0) + "_\n");
                System.out.println(fibquestion.getPossibleAnswer(1) + "_\n");
                System.out.println(fibquestion.getPossibleAnswer(2) + "_\n");
            }
       });
   }

   public JPanel addAnswer(final int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("Possible Blank Filler "+num);
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor= GridBagConstraints.FIRST_LINE_START ;
            gbc.weighty=1.0;
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
            final JTextField answer = new JTextField(10);
            this.add(answer);
            if (fibquestion.getPossibleAnswers() == null) {
               fibquestion.setPossibleAnswers(new String [1]);
            }
            else
            {
                String[] new_answers = new String[fibquestion.getNumberOfPossibleAnswers()+1];
                System.arraycopy(fibquestion.getPossibleAnswers(),0,new_answers,0,fibquestion.getNumberOfPossibleAnswers());
                fibquestion.setPossibleAnswers(new_answers);
                }
            answer.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fibquestion.getPossibleAnswers()[num] = answer.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fibquestion.getPossibleAnswers()[num] = answer.getText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                fibquestion.getPossibleAnswers()[num] = answer.getText();
            }
    });
            
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(answer,gbc);
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