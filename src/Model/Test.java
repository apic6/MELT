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
        Modeller model = new Modeller();
        model.loadPapers("src/Papers2.xml");
        try {
            model.savePapers("src/Papers3.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}