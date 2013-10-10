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
import Viewer.TestWizard;
import Viewer.Viewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbaxkak4
 */
public class Controller {
     private Modeller amodel;
     private Viewer aview;
    
    public Controller(Viewer view,Modeller model) {   //constructor of controller class
        
        
        view.addListener(new ViewerEventListener());
        amodel=model;
        aview=view;
        
    }
    



 class ViewerEventListener implements ActionListener {          //How to distinguish between events without breaking encapsulation?Buttons are private...      
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "login":{
                String username = LoginScreen.getUsername();
                String pass= LoginScreen.getPassword();
                }
                    break;
                case "submit":{
                }
                    break;
                case "finish":{
                  QuestionPaper  p;
                  p=TestWizard.getQuestionPaper();
                  //System.out.println("yihaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAAAAAAAAAAAAAAAAAA");
                  //System.out.println(p.toXML(amodel));
                try {
                    amodel.addPaper(p);
                    amodel.savePapers(null);
                    } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                }
                    break;
                
            }
               
        }}



}