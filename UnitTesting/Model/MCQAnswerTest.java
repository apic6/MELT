/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.StudentSubmission.MCQAnswer;
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
public class MCQAnswerTest {

    private static MCQAnswer instance;

    public MCQAnswerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new MCQAnswer(1, 1);
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
     * Test of getID method, of class MCQAnswer.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");

        int expResult = 1;
        int result = instance.getQuestionID();
        assertEquals("Result is not the same as passed during creation", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class MCQAnswer.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        
        int expResult = 1;
        int result = instance.getAnswer();
        assertEquals("Answer is differnet to value in construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toXML method, of class MCQAnswer.
     */
    @Test
    public void testToXML() {
        System.out.println("toXML");
        
        String expResult = "<MCQAnswer>\n";
        expResult += "<AnswerID>" + 1 + "</AnswerID>\n";
        expResult += "<Answer>" + 1 + "</Answer>\n";
        expResult += "</MCQAnswer>\n";
        String result = instance.toXML();
        assertEquals("Expected result of toXML is different", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}