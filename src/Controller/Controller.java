/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
//should be able to handle button listeners in the viewer and model methods
/**
 *
 * @author mbaxkak4
 */
import Model.Modeller;
import Model.questionPaper.QuestionPaper;
import Viewer.LoginScreen;
import Viewer.Marker;
import Viewer.PaperView;
import Viewer.SectionEditor;
import Viewer.Student;
import Viewer.SubsectionEditor;
import Viewer.TeacherView;
import Viewer.TestWizard;
import Viewer.Viewer;
import Viewer.Welcome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author mbaxkak4
 */
public class Controller {
      private Modeller amodel;
  
    public Controller(Viewer view,Modeller model) {   //constructor of controller class
    
       Welcome.addListener(new ViewerEventListener());
        amodel=model;
    
       
    }
    



 class ViewerEventListener implements ActionListener {          
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "login":{
                  String username = LoginScreen.getUsername();
                  String pass= LoginScreen.getPass();
                  if (pass.equals("English")){
                  JFrame frame;
                  frame=LoginScreen.getFrame();
                  frame.setContentPane(new Student(frame,amodel,username));
                  frame.setVisible(true);
                  
                  
                  }
                }
                    break;
                    
                case "Create a New Test":{
                  JFrame frame;
                  frame=TeacherView.getFrame();
                  frame.setContentPane(new TestWizard(frame,amodel));
                  frame.setVisible(true);
                  TestWizard.addListener(new Mouse());
                  Timer timer=new Timer(true);
                  timer.scheduleAtFixedRate(new TimerTask(){
                  @Override
                     public void run() {
                     saveNewTest();
                     }},0,2000);}
                     break;
                    
                case "I am a Teacher":{
                  JFrame frame;
                  frame=Welcome.getFrame();
                  frame.setContentPane(new TeacherView(frame,amodel));
                  frame.setVisible(true);
                  TeacherView.addListener(new ViewerEventListener()); 
                }break;
                  case "I am a Student":{
                  JFrame frame;
                  frame=Welcome.getFrame();
                  frame.setContentPane(new LoginScreen(frame,amodel));
                  LoginScreen.addListener(new ViewerEventListener());
                  frame.setVisible(true);
                  //TeacherView.addListener(new ViewerEventListener()); 
                }break;  
                    
                  case "markTrigger":{
                Marker.addListeners(new Mouse());
                Timer timer=new Timer(true);
                timer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run() {
                     saveMarks();
                     }},0,2000);}break;
                    
                  case "editTrigger":{
                        
                 JFrame frame;
                 QuestionPaper paper;
                 frame=TeacherView.getFrame();
                 frame.setContentPane(new TestWizard(frame,amodel,TeacherView.getPaper()));
                 frame.setVisible(true);
                 TestWizard.addListener(new Mouse());
                 Timer timer=new Timer(true);
                 timer.scheduleAtFixedRate(new TimerTask(){
                 @Override
                 public void run() {
                   // System.err.println("jskahkjdashjkdhsakfhskdfjsakfhjks");
                     saveOldTest();
                     }},0,2000);}break;
                   
                    case "startTrigger": {
                   // PaperView.addListeners(new Mouse());
                        Timer timer=new Timer(true);
                        timer.scheduleAtFixedRate(new TimerTask(){
                           @Override
                           public void run() {
                           saveSubmission();
                           }},0,2000); }break;
                
            }
               
        }}
 
 class ViewerDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
           updateModel(); 
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
           updateModel();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
           updateModel(); 
        }
 
        private void updateModel(){
            //
           // System.out.println("it works");
        }
 }

class ViewerFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            //System.out.println("works");
        }

        @Override
        public void focusLost(FocusEvent e) {
             //  saveTest();
        }

}

public class Mouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
          //  System.err.println(e.getSource());
          // saveTest();  //         
            System.err.println("it worksjsjsjsjsjhkhfksadf");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

}

private void saveNewTest(){
 QuestionPaper  p;
                     p=TestWizard.getQuestionPaper();
               //  System.out.println(p.getPaperID());
                     amodel.loadPapers();
                 
                try {
                    // p.getPaperID();
                    if(amodel.getPaper(p.getPaperID()-1)!=null){
                    amodel.removePaper(p.getPaperID()-1);
                    amodel.addPaper(p);
                    
                    }
                    else {
                    amodel.addPaper(p);
                    }
                     
                    amodel.savePapers(null);
                    } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
}
private void saveOldTest(){
 QuestionPaper  p;
                     p=TestWizard.getQuestionPaper();
               //  System.out.println(p.getPaperID());
                     amodel.loadPapers();
                 
                try {
                    // p.getPaperID();
                   
                    amodel.removePaper(p.getPaperID()-1);
                    amodel.addPaper(p.getPaperID()-1,p);             //it always adds at the end of the list...
                    
                 
                    amodel.savePapers(null);
                    } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
}

private void saveMarks(){



}

private void saveSubmission(){

}

}
