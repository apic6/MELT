/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.Dimension;
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
    public Modeller model;
    public JTabbedPane tabs;
    
    public TestWizard(JFrame frame,Modeller model,JTabbedPane tabs){
        this.model = model;
        mainFrame = frame;
        this.tabs = tabs;
        initComponents();
    
}

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        
        if(tabs!=null){
            add(tabs,con);
        }
        else{
        
        
        
        tabs = new JTabbedPane();
        
        JPanel tab1 = new JPanel();
        tab1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        tab1.setPreferredSize(new Dimension(400, 400));
        tab1.add(new TestSection(mainFrame,model),c);
        tabs.addTab("tab1", tab1);
  
        JPanel tab2 = new JPanel();
        tab2.setLayout(new GridBagLayout());
        tab2.add(new TestSection(mainFrame,model),c);
        tabs.addTab("tab2", tab2);
        
        add(tabs,con);
        }
        
        final JTabbedPane tabs_copy = tabs;
        JButton addSection = new JButton("addSection");
        addSection.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPanel tab3 = new JPanel();
            tab3.setLayout(new GridBagLayout());
            GridBagConstraints c2 = new GridBagConstraints();
            c2.gridx = 0;
            c2.gridy = 0;
            tab3.add(new TestSection(mainFrame,model),c2);
            tabs_copy.addTab("tab3",tab3);
                  ((Viewer)mainFrame).guiChanger(new TestWizard(mainFrame,model,tabs_copy));
            }
        });
        con.gridy = 1;
        add(addSection,con);
    }

}