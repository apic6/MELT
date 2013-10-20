/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mbaxkak4
 */
public class Marker extends JPanel {
    
    private static JFrame mainFrame;
    private Modeller model;
    private QuestionPaper paper;
    public Marker(Modeller model,JFrame frame,QuestionPaper paper) {
    this.mainFrame=frame;
    this.model=model;
    this.paper=paper;
    initComponents();
    
    
    }
    
    void initComponents(){
    
        setLayout(new GridBagLayout());
         GridBagConstraints c= new GridBagConstraints();
         
         
    
    
    
    
    
    }
    
    
    
  public static void addListeners(){
  
  }  
  
    
}
