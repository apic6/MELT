/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author mbaxkmt6
 */
public class TestWizard extends JPanel{
    public JFrame mainFrame;
    public Modeller amodel;
    
    public TestWizard(JFrame frame,Modeller model){
        amodel = model;
        mainFrame = frame;
        initComponents();
    
}

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tab1 = new JPanel();
        tab1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
                
        tab1.add(new JButton("test2"),c);
        tabbedPane.addTab("tab1", tab1);
  
        JPanel tab2 = new JPanel();
        tab2.setLayout(new GridBagLayout());
        tab2.add(new JButton("test3"),c);
        tabbedPane.addTab("tab2", tab2);
        
        add(tabbedPane);
    }

}