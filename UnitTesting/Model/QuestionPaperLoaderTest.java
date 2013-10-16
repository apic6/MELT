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
    private static QuestionPaperLoader instance;
    
    public QuestionPaperLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new QuestionPaperLoader();
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
        
        int expResult = 0;
        int result = instance.readPapers();
        assertTrue("Load papers has returned a negative value meaning -ve papers were loaded, simply impossible!", result >= expResult);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionPapers method, of class QuestionPaperLoader.
     */
    @Test
    public void testGetQuestionPapers() {
        System.out.println("getQuestionPapers");
        
        instance.readPapers();
        
        ArrayList result = instance.getQuestionPapers();
        assertNotNull("The list of papers is null, woops!", result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionPaper method, of class QuestionPaperLoader.
     */
    @Test
    public void testGetQuestionPaper() {
        System.out.println("getQuestionPaper");
        int i = 0;
        
        instance.readPapers();
        
        QuestionPaper result = instance.getQuestionPaper(i);
        assertNotNull("The returned paper is null, woops!", result);

        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}