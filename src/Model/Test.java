/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jamie
 */
public class Test {
    public static void main(String argv[]) {
        /*
        Modeller model = new Modeller();
        model.loadPapers("src/Papers2.xml");
        try {
            model.savePapers("src/Papers3.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        StudentSubmission submission = new StudentSubmission(1, 10111);
        SubmissionSection submSection2 = new SubmissionSection(2);
        SubmissionSection submSection1 = new SubmissionSection(1);        
        
        submission.addSection(submSection2);
        submission.addSection(submSection1);
        for (int i = 0; i<submission.getSize(); i++) {
            System.out.println("ID: " + submission.getSection(i).getID());
        }
        submission.normalise();
        for (int i = 0; i<submission.getSize(); i++) {
            System.out.println("ID: " + submission.getSection(i).getID());
        }        
    }
}