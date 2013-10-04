/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Init;


import Controller.Controller;
import Model.Modeller;
import Viewer.Viewer;


/**
 *
 * @author mbaxkak4
 */
public class InitClass {
    
    public static void main(String[] args) {
        // TODO code application logic here
        //MODEL-VIEW-CONTROLLER-INITIALIZATION HERE
     Modeller model=new Modeller();
     Viewer view=new Viewer(model);
     Controller control=new Controller(view,model);
     
     view.setVisible(true);
        
   
    }
    
}
