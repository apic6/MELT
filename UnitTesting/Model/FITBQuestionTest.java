/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.FITBQuestion;
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
public class FITBQuestionTest {

    private static FITBQuestion instance;
    private static String[] possibleAnswers;
    private static String[] question;

    public FITBQuestionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
        possibleAnswers = new String[2];
        possibleAnswers[0] = "Hello";
        possibleAnswers[1] = "Goodbye";
        
        question = new String[2];
        question[0] = "Hello";
        question[1] = "Goodbye";
        
        instance = new FITBQuestion(question, "Instructions", possibleAnswers, 1);
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
     * Test of getInstructions method, of class FITBQuestion.
     */
    @Test
    public void testGetInstructions() {
        System.out.println("getInstructions");
        
        String expResult = "Instructions";
        String result = instance.getInstructions();
        assertEquals("Error: Differs from construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestion method, of class FITBQuestion.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        
        String expResult = "Question?";
        String result = instance.getQuestion();
        assertEquals("Error: Differs from construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfPossibleAnswers method, of class FITBQuestion.
     */
    @Test
    public void testGetNumberOfPossibleAnswers() {
        System.out.println("getNumberOfPossibleAnswers");
        
        int expResult = 2;
        int result = instance.getNumberOfPossibleAnswers();
        assertEquals("Error: Differs from construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPossibleAnswer method, of class FITBQuestion.
     */
    @Test
    public void testGetPossibleAnswer() {
        System.out.println("getPossibleAnswer");
        int i = 0;
        
        String expResult = "Hello";
        String result = instance.getPossibleAnswer(i);
        assertEquals("Error: Differs from construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setMark method, of class FITBQuestion.
     */
    @Test
    public void testSetMark() {
        System.out.println("setMark");
        
        int expected = 1;
        int result = instance.getMark();
        assertEquals("Error: Differs from construction", expected, result);
        
        instance.setMark(2);
        
        expected = 2;
        result = instance.getMark();
        assertEquals("Error: Differs from construction", expected, result);
        
        
        instance.setMark(1);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getMark method, of class FITBQuestion.
     */
    @Test
    public void testGetMark() {
        System.out.println("getMark");
        
        int expResult = 1;
        int result = instance.getMark();
        
        assertEquals("Error: Differs from construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toXML method, of class FITBQuestion.
     */
    @Test
    public void testToXML() {
        System.out.println("toXML");
        
        String expResult = "<Question type=\"FITBQ\">\n"
                + "<Instructions>Instructions</Instructions>\n"
                + "<QuestionText>Question?</QuestionText>\n"
                + "<PossibleAnswer>Hello</PossibleAnswer>\n"
                + "<PossibleAnswer>Goodbye</PossibleAnswer>\n"
                + "<Mark>1</Mark>\n"
                + "</Question>\n";
        
        String result = instance.toXML();
        assertEquals("Error: Differs from construction", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}