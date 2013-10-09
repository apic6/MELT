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
import Viewer.LoginScreen;
import Viewer.Viewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                case "SaveTest":{
                }
                    break;
                case "SubmitTest":{}
                    break;
                
            }
               
        }}



}