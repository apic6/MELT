/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mbaxkak4
 */
public final class FIBQPanel extends JPanel {
    private JFrame mainFrame;
    private Modeller model;
    GridBagConstraints c = new GridBagConstraints();
    int j=0;
   //public FIBQPanel (JFrame frame,Modeller model) {
    public FIBQPanel () { 
      //  this.model=model;
      //  this.mainFrame=frame;
        initComponents();
}
  
   
   void initComponents() {
      
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
      JTextField firstPart=new JTextField(10);
      this.add(firstPart,c);
      c.gridx=2;
      c.gridy=0;
      JLabel blank=new JLabel("Blank");
      this.add(blank,c);
      c.gridx=3;
      c.gridy=0;
      JTextField secondPart=new JTextField(10);
      this.add(secondPart,c);
      c.gridx=0;
      c.gridy=1;
      c.ipady = 0 ;
      c.weighty = 1.0 ;
      c.weightx = 1.0 ;
//      c.ipady = 10 ;
      c.anchor = GridBagConstraints.FIRST_LINE_START;
      
      JButton addAnswerButton=new JButton("Add Answer");
      this.add(addAnswerButton,c);
      
      final JPanel answerPanel = new JPanel();
      answerPanel.setLayout(new GridBagLayout());
      
      c.gridx = 1 ;
      c.gridy=1;
      c.gridwidth = GridBagConstraints.REMAINDER ;
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
       c.gridy = 2 ;
       c.fill = GridBagConstraints.HORIZONTAL;
       this.add(submit, c);
       
   }

   public JPanel addAnswer(int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("Possible Blank Filler "+num);
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor= GridBagConstraints.FIRST_LINE_START ;
            gbc.weighty=1.0;
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
            JTextField answer = new JTextField(10);
            this.add(answer);
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(answer,gbc);
            return tempPanel;
            
        }
   public static void main(String argv[]) {
       JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 0));
        //frame.setPreferredSize(new Dimension(1200, 800));

        frame.add(new FIBQPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
   }
}
