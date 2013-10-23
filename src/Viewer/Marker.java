/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.questionPaper.QuestionPaper;
import Model.StudentSubmission.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mbaxkak4
 */

import Model.StudentSubmission.*;
import Model.questionPaper.Question;
import Model.questionPaper.Section;
import Model.questionPaper.SubSection;

public class Marker extends JPanel {
    
    JLabel test=new JLabel();
    private static JFrame mainFrame;
    private Modeller model;
    private QuestionPaper paper;
    private Submission submission;
    private JList submissionList;
    private DefaultListModel listModel;
    private ListSelectionModel listSelectionModel;
    private JPanel rightPanel=new JPanel();
    public Marker(Modeller model,JFrame frame,QuestionPaper paper) {
    this.mainFrame=frame;
    this.model=model;
    this.paper=paper;
    initComponents();
    
    
    }
    
    void initComponents(){
    
        
       
        
        
        System.err.println(paper.getPaperID());
        setLayout(new GridBagLayout());
        GridBagConstraints con= new GridBagConstraints();
         
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 1.0;
        con.weighty = 1.0;
        con.fill = GridBagConstraints.BOTH;
        
        JPanel leftPanel=new JPanel();
        JScrollPane leftScroll=new JScrollPane(leftPanel);////////////////may be reversed
        
        
        
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBorder(new TitledBorder("Student Submissions for "+paper.getTitle()));
        final ArrayList<Submission> submissions=model.getSubmissions();
        GridBagConstraints c1= new GridBagConstraints();
        
        c1.gridx=0;
        c1.gridy=0;
        c1.anchor = GridBagConstraints.FIRST_LINE_START ;      
        c1.weightx = 1 ;
        c1.weighty = 1 ;
        c1.fill = GridBagConstraints.BOTH ;
        
        listModel = new DefaultListModel();
        submissionList=new JList(listModel);
        listSelectionModel=submissionList.getSelectionModel();
        //listSelectionModel.setValueIsAdjusting(false);
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
             @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()){
                int f=submissionList.getSelectedIndex();
                submission=submissions.get(f);
                test.setText("jhskjhsa   "+f);
                       
                  }         
                 }
        });
        
        
        for(int i=0;i<submissions.size();++i){
        submission=submissions.get(i);
        String subID=submission.getStudentID()+"";
        listModel.addElement(subID);
        
        
        }
        submissionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        submissionList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        
        
        JScrollPane listScroller = new JScrollPane(submissionList);
        leftPanel.add(listScroller,c1);
        this.add(leftScroll,con);
        ///////////////////////////////////////////////////
        
        
        con.gridx=1;
        con.weightx=2.5;
//        JPanel rightPanel=new JPanel();
        JScrollPane rightScroll=new JScrollPane(rightPanel);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBorder(new TitledBorder("Submission Marker"));
        rightPanel.add(test);
        for(int i=0;i<submission.getSize();++i){
          //  SubmissionSection subsec;
        
        }
        
        
        /////////MarkView
    
        this.add(rightScroll,con);
    }
    
    
    
  public static void addListeners(MouseListener mouse){
   mainFrame.addMouseListener(mouse);
  }  

  void displaySubmission(Submission sub){
      paper=model.getPaper(sub.getPaperID());
   for (int k=0;k<sub.getSize();++k){
       SubmissionSection sec=sub.getSection(k);
       Section paperSec=paper.getSection(k);
       for(int l=0;l<sec.getSize();++l){
           SubmissionSubSection subsec=sec.getSubSection(l);
           SubSection paperSubsec=paperSec.getSubSection(l);
           for(int m=0;m<subsec.getSize();m++){
       
           Answer ans=subsec.getAnswer(m);
           Question ques=paperSubsec.getQuestion(m);
           JLabel questionLabel=new JLabel(ques.getQuestion());
           //JLabel answerLabel=new JLabel(ans.);
           rightPanel.add(questionLabel);
           //rightPanel.add(answerLabel);
           }
       }
        
   
   
   }
  
  }
    
}
