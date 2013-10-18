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
import Model.QuestionPaper;
import Viewer.LoginScreen;
import Viewer.SectionEditor;
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
    



 class ViewerEventListener implements ActionListener {          //How to distinguish between events without breaking encapsulation?Buttons are private...      
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "login":{
                  String username = LoginScreen.getUsername();
                  String pass= LoginScreen.getPass();
                }
                    break;
                case "Create a New Test":{
                  JFrame frame;
                  frame=TeacherView.getFrame();
                  frame.setContentPane(new TestWizard(frame,amodel));
                  frame.setVisible(true);
                  //TestWizard.addListener(new Mouse());
                  Timer timer=new Timer(true);
                  timer.scheduleAtFixedRate(new TimerTask(){
                  @Override
                     public void run() {
                     save();
                     }},0,2000);}
                     break;
                case "I am a Teacher":{
                  JFrame frame;
                  frame=Welcome.getFrame();
                  frame.setContentPane(new TeacherView(frame,amodel));
                  frame.setVisible(true);
                  TeacherView.addListener(new ViewerEventListener()); 
                }
                
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
               save();
        }

}

public class Mouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
         save();           
            
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

private void save(){
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

}