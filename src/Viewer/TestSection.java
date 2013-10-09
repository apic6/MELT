/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author mbaxkmt6
 */
public class TestSection extends JPanel{
    public JFrame mainFrame;
    public Modeller model;
    private JTextArea title;
    private JTextArea description;
    private JTextArea instruction;
    
    
    public TestSection(JFrame frame,Modeller model){
        this.model = model;
        mainFrame = frame;
        initComponents();
    }

    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 1.0;
        con.anchor = GridBagConstraints.NORTHWEST;
        title = new JTextArea("title");
        add(title,con);
        
        description = new JTextArea("description");
        con.gridy = 1;
        add(description,con);
        
        instruction = new JTextArea("instruction");
        con.gridy = 2;
        add(instruction,con);
        
    }
}
