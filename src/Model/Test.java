/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jamie
 */
public class Test {
    public static void main(String argv[]) {
        QuestionPaperLoader loader = new QuestionPaperLoader();
        System.out.println( loader.ReadPapers() );
    }
}
