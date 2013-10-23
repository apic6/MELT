/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.StudentSubmission.FITBAnswer;
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
public class FITBAnswerTest {
    private static FITBAnswer instance;
    
    public FITBAnswerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new FITBAnswer(1, "Bob");
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
     * Test of getID method, of class FITBAnswer.
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
     * Test of getAnswer method, of class FITBAnswer.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        
        String expResult = "Bob";
        String result = instance.getAnswer();
        assertEquals("Result is not the same as passed during creation", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toXML method, of class FITBAnswer.
     */
    @Test
    public void testToXML() {
        System.out.println("toXML");
        String expResult = "<FITBAnswer>\n<AnswerID>" + 1 + "</AnswerID>\n";
        expResult += "<Answer>Bob</Answer>\n";
        expResult += "</FITBAnswer>\n";
        
        String result = instance.toXML();
        assertEquals("Expected result of toXML is different", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}