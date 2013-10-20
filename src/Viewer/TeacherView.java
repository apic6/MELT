/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author mbaxkak4
 */
public class TeacherView extends JPanel {
    
    private int j;
    private QuestionPaper paper;
    private static JFrame mainFrame;
    private Modeller amodel;
    
    public TeacherView(JFrame frame,Modeller model){
        
        mainFrame = frame;
        amodel = model;
        initComponents();
        
    }
    
    
       private static JButton createTest;
       private java.awt.Label previousLabel;
   
    private void initComponents()  {
        
        previousLabel=new Label();
        createTest=new JButton() ;
        final TeacherView tView=this;
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
       
        
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridy = 0;
        c.ipady = 50;
        c.ipadx = 30;
        c.weightx=1.0;
        c.insets = new Insets(20,20,20,20);
        c.weighty = 10;
        createTest.setText("Create a New Test");
        createTest.setPreferredSize(new Dimension(200, 40));
//        createTest.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                  ((Viewer)mainFrame).guiChanger(new TestWizard(mainFrame,amodel));
//            }
//        });
        this.add(createTest,c);
       
        c.gridy=1;
        c.weightx=1.0;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight=GridBagConstraints.REMAINDER;
        c.fill=GridBagConstraints.BOTH;
        c.weighty = 20;
        
        
       JPanel BottomPanel=new JPanel();
        BottomPanel.setLayout(new GridBagLayout()); //////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!
       JScrollPane Scroll=new JScrollPane(BottomPanel) ;
       
      
      
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 1;
        c1.weighty = 1;
        c1.gridx = GridBagConstraints.RELATIVE;
        c1.gridy = 1;
        c1.ipady = 30;
        c1.ipadx = 80;
        c1.anchor = GridBagConstraints.CENTER;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        previousLabel.setAlignment(java.awt.Label.CENTER);
        previousLabel.setBackground(new java.awt.Color(245, 245, 245));
        previousLabel.setFont(new java.awt.Font("Monospaced", 3, 16)); // NOI18N
        previousLabel.setText("List of older English Language tests ");
        BottomPanel.add(previousLabel,c1);
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.anchor = GridBagConstraints.SOUTH;
        c2.gridx = GridBagConstraints.RELATIVE;
        c2.fill = GridBagConstraints.BOTH;
        c2.weighty=1;
        c2.ipadx = 10;
        c2.ipady = 10;
        c2.insets = new Insets(50, 0, 30, 20);
        c2.weightx = 0.5;
        c2.insets = new Insets(50, 20, 30, 0);
        c2.anchor = GridBagConstraints.SOUTH;
       
        c2.gridy = 2;
        
       
        
        ArrayList<QuestionPaper> papers = amodel.getPapers();
      
        for(int i=0;i<papers.size();++i){
            paper=papers.get(i);
            j=i;
            c2.gridy=c2.gridy+i;
            c2.gridx = 0;
            BottomPanel.add(new PaperPreviewer(papers.get(i)),c2);
            
            c2.gridx=1;
            JButton editButton=new JButton("Preview Test");
            editButton.addActionListener(new ActionListener(){
              @Override
           public void actionPerformed(ActionEvent evt){
           mainFrame.setContentPane(new PaperView(paper, mainFrame, null,tView, -1));
           mainFrame.setVisible(true);
        
        }
            
            });
            BottomPanel.add(editButton,c2);
            
            c2.gridx=2;
            JButton previewButton=new JButton("Edit Test");
            previewButton.addActionListener(new ActionListener(){
              
            @Override
            public void actionPerformed(ActionEvent evt){
            mainFrame.setContentPane(new TestWizard(mainFrame,amodel,paper));
            mainFrame.setVisible(true);
                //TestWizard editTest=new TestWizard(mainFrame,amodel,paper); 
            
        }
            
            
            });
            BottomPanel.add(previewButton,c2);
           
        }
        
      
                 this.add(Scroll,c);
    
      }

   
  public static void addListener(ActionListener mal){
  createTest.addActionListener(mal);
   }
   public static JFrame getFrame(){
   return mainFrame;}
  


}
