/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Viewer.PaperViews.PaperView;
import Model.Modeller;
import Model.questionPaper.QuestionPaper;
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
   // private static JButton markButton;
   // private static JButton editButton;
    private int j;
    private static QuestionPaper paper;
    private static JFrame mainFrame;
    private Modeller amodel;
    private static JButton markTrigger=new JButton("markTrigger");
    private static JButton editTrigger=new JButton("editTrigger");
    
    public TeacherView(JFrame frame,Modeller model){
        
        mainFrame = frame;
        amodel = model;
        initComponents();
        
    }
    
    
       private static JButton createTest;
       private java.awt.Label previousLabel;
      // private static JButton markButton;
   
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
        this.add(previousLabel,c1);
        
        
        
        
        
        
        
        
       
        c.gridy=2;
        c.weightx=1.0;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight=GridBagConstraints.REMAINDER;
        c.fill=GridBagConstraints.BOTH;
        c.weighty = 20;
        
        
       JPanel BottomPanel=new JPanel();
       BottomPanel.setLayout(new GridBagLayout()); //////////////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!
       JScrollPane Scroll=new JScrollPane(BottomPanel) ;
       
      
      
        
      
        
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
        
       
        
        final ArrayList<QuestionPaper> papers = amodel.getPapers();
        
        for(int i=0;i<papers.size();++i){
            
            
            //paper=papers.get(i);
            final int j=i;
            c2.gridy=c2.gridy+i;
            c2.gridx = 0;
            BottomPanel.add(new PaperPreviewer(papers.get(j)),c2);
            
            c2.gridx=1;
            JButton previewButton=new JButton("Preview Test");
            previewButton.addActionListener(new ActionListener(){
              @Override
           public void actionPerformed(ActionEvent evt){
           mainFrame.setContentPane(new PaperView(papers.get(j), mainFrame, null,tView, -1));
           mainFrame.setVisible(true);
        
        }
            
            });
            BottomPanel.add(previewButton,c2);
            
            c2.gridx=2;
            JButton editButton=new JButton("Edit Test");
            editButton.addActionListener(new ActionListener(){
              
            @Override
            public void actionPerformed(ActionEvent evt){
//            mainFrame.setContentPane(new TestWizard(mainFrame,amodel,papers.get(j)));
//            mainFrame.setVisible(true);
            paper=papers.get(j);
            editTrigger.doClick();
                
            
        }});
            BottomPanel.add(editButton,c2);
            
            c2.gridx=3;
            
            JButton soome=new JButton();
            
            
            JButton markButton=new JButton ("Mark Test");
           
            markButton.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new Marker(amodel,mainFrame,papers.get(j)));
                mainFrame.setVisible(true);  
                markTrigger.doClick();
                  }
             
            });
            BottomPanel.add(markButton,c2);
            }
        this.add(Scroll,c);
    }

   
  public static void addListener(ActionListener mal){
  createTest.addActionListener(mal);
  markTrigger.addActionListener(mal);
  editTrigger.addActionListener(mal); 
  
   }
   public static JFrame getFrame(){
   return mainFrame;}
  
   public static QuestionPaper getPaper(){
   
   return paper;}

}
