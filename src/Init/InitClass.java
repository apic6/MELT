/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Init;

import Viewer.ViewerClass;
import Controller.ControlClass;
import Model.ModelClass;


/**
 *
 * @author mbaxkak4
 */
public class InitClass {
    
    public static void main(String[] args) {
        // TODO code application logic here
        //MODEL-VIEW-CONTROLLER-INITIALIZATION HERE
     ControlClass control=new ControlClass();
     ViewerClass view=new ViewerClass();
     ModelClass model=new ModelClass();
     
     view.setVisible(true);
        
   
    }
    
}
