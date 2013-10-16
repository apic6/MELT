/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mbaxkak4
 */
public class QuestionPaperLoaderTest {
    
    public QuestionPaperLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readPapers method, of class QuestionPaperLoader.
     */
    @Test
    public void testReadPapers() {
        System.out.println("readPapers");
        QuestionPaperLoader instance = new QuestionPaperLoader();
        int expResult = 0;
        int result = instance.readPapers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionPapers method, of class QuestionPaperLoader.
     */
    @Test
    public void testGetQuestionPapers() {
        System.out.println("getQuestionPapers");
        QuestionPaperLoader instance = new QuestionPaperLoader();
        ArrayList expResult = null;
        ArrayList result = instance.getQuestionPapers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionPaper method, of class QuestionPaperLoader.
     */
    @Test
    public void testGetQuestionPaper() {
        System.out.println("getQuestionPaper");
        int i = 0;
        QuestionPaperLoader instance = new QuestionPaperLoader();
        QuestionPaper expResult = null;
        QuestionPaper result = instance.getQuestionPaper(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}