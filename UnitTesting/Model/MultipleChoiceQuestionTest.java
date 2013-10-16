/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class MultipleChoiceQuestionTest {

    private static MultipleChoiceQuestion instance;

    public MultipleChoiceQuestionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        String[] answers = new String[3];
        answers[0] = "a";
        answers[1] = "b";
        answers[2] = "c";

        int[] possibleAnswers = new int[1];
        possibleAnswers[0] = 1;

        instance = new MultipleChoiceQuestion("Question?", answers, "Instructions", possibleAnswers, 1);
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
     * Test of getInstructions method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testGetInstructions() {
        System.out.println("getInstructions");

        String expResult = "Instructions";
        String result = instance.getInstructions();
        assertEquals("Instructions aren't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestion method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");

        String expResult = "Question?";
        String result = instance.getQuestion();
        assertEquals("Question isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfAnswers method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testGetNumberOfAnswers() {
        System.out.println("getNumberOfAnswers");

        int expResult = 3;
        int result = instance.getNumberOfAnswers();
        assertEquals("The number of answers isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        int ID = 0;

        String expResult = "a";
        String result = instance.getAnswer(ID);
        assertEquals("First answer isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfPossibleAnswers method, of class
     * MultipleChoiceQuestion.
     */
    @Test
    public void testGetNumberOfPossibleAnswers() {
        System.out.println("getNumberOfPossibleAnswers");

        int expResult = 1;
        int result = instance.getNumberOfPossibleAnswers();
        assertEquals("Number of correct answers isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPossibleAnswer method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testGetPossibleAnswer() {
        System.out.println("getPossibleAnswer");
        int i = 0;

        int expResult = 1;
        int result = instance.getPossibleAnswer(i);
        assertEquals("Answer isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getMark method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testGetMark() {
        System.out.println("getMark");

        int expResult = 1;
        int result = instance.getMark();
        assertEquals("Mark isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setMark method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testSetMark() {
        System.out.println("setMark");
        int mark = 0;

        instance.setMark(mark);

        int after = instance.getMark();

        instance.setMark(1);

        assertTrue("Mark wasn't updated", after == 0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toXML method, of class MultipleChoiceQuestion.
     */
    @Test
    public void testToXML() {
        System.out.println("toXML");
        
        String expResult =  "<Question type=\"MCQ\">\n"
                + "<Instructions>Instructions</Instructions>\n"
                + "<QuestionText>Question?</QuestionText>\n"
                + "<Answer>a</Answer>\n"
                + "<Answer>b</Answer>\n"
                + "<Answer>c</Answer>\n"
                + "<PossibleAnswer>1</PossibleAnswer>\n"
                + "<Mark>1</Mark>\n"
                + "</Question>\n";
        
        String result = instance.toXML();
        
        assertEquals("XML isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}