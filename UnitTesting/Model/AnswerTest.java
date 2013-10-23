/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.StudentSubmission.Answer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mbgm8je3
 */
public class AnswerTest {
    
    public AnswerTest() {
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
     * Test of getID method, of class Answer.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Answer instance = new Answer();
        
        int result = instance.getQuestionID();
        assertTrue("ID negative, woops!", result >= 0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toXML method, of class Answer.
     */
    @Test
    public void testToXML() {
        System.out.println("toXML");
        Answer instance = new Answer();
        String expResult = "Error";
        String result = instance.toXML();
        assertEquals("Only result of Ansewr.toXML is 'Error', no other result should happen", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}