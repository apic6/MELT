/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.StudentSubmission;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author mbaxkak4
 */
public class Marker extends JPanel {
    
    private static JFrame mainFrame;
    private Modeller model;
    private QuestionPaper paper;
    private StudentSubmission submission;
    private JList submissionList;
    private DefaultListModel listModel;
    
    public Marker(Modeller model,JFrame frame,QuestionPaper paper) {
    this.mainFrame=frame;
    this.model=model;
    this.paper=paper;
    initComponents();
    
    
    }
    
    void initComponents(){
    
       
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
        ArrayList<StudentSubmission> submissions=model.getSubmissions();
        GridBagConstraints c1= new GridBagConstraints();
        
        c1.gridx=0;
        c1.gridy=0;
        c1.anchor = GridBagConstraints.FIRST_LINE_START ;      
        c1.weightx = 1 ;
        c1.weighty = 1 ;
        c1.fill = GridBagConstraints.BOTH ;
        
        listModel = new DefaultListModel();
        submissionList=new JList(listModel);
        
        
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
        JPanel rightPanel=new JPanel();
        JScrollPane rightScroll=new JScrollPane(rightPanel);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBorder(new TitledBorder("Submission Marker"));
        
        /////////MarkView
    
        this.add(rightScroll,con);
    }
    
    
    
  public static void addListeners(){
  
  }  
  
    
}
