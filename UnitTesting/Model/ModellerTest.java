/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.QuestionPaper;
import Model.StudentSubmission.Submission;
import java.util.ArrayList;
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
public class ModellerTest {

    private static Modeller instance;

    public ModellerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Modeller();
        instance.loadPapers();
        instance.loadSubmissions();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class Modeller.
     */
    @Test
    public void testInit() {
        System.out.println("init");

        instance.init();

        int numberOfPapers = instance.getNumberOfPapers();
        int numberOfSubmissions = instance.getNumberOfSubmission();

        assertTrue("numberOfPapers is < 0, init failed", numberOfPapers >= 0);
        assertTrue("numberOfSubmissions is < 0, init failed", numberOfSubmissions >= 0);

        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNextID method, of class Modeller.
     */
    @Test
    public void testGetNextID() {
        System.out.println("getNextID");

        int expResult = 0;
        int result = instance.getNextID();
        assertTrue("ID isn't a sensible value", result >= expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPapersByStudentID method, of class Modeller.
     */
    @Test
    public void testGetPapersByStudentID() {
        System.out.println("getPapersByStudentID");
        int studentID = 12301230;


        ArrayList result = instance.getPapersByStudentID(studentID);

        assertTrue("array list is wrongly empty", result.size() > 0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfPapers method, of class Modeller.
     */
    @Test
    public void testGetNumberOfPapers() {
        System.out.println("getNumberOfPapers");

        int expResult = 2;
        int result = instance.getNumberOfPapers();
        assertEquals("Wrong number of papers", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPaper method, of class Modeller.
     */
    @Test
    public void testGetPaper() {
        System.out.println("getPaper");
        int index = 0;

        QuestionPaper result = instance.getPaper(index);
        assertNotNull("Question Paper is wrongly null", result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of addPaper method, of class Modeller.
     */
    @Test
    public void testAddPaper() {
        System.out.println("addPaper");

        QuestionPaper paper = null;

        int before = instance.getNumberOfPapers();
        instance.addPaper(paper);
        int after = instance.getNumberOfPapers();

        assertEquals("Paper wasn't added correctly", before + 1, after);

        instance.removePaper(after - 1);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of removePaper method, of class Modeller.
     */
    @Test
    public void testRemovePaper() {
        System.out.println("removePaper");

        int before = instance.getNumberOfPapers();
        instance.removePaper(before - 1);
        int after = instance.getNumberOfPapers();

        assertTrue("Paper wasn't removed correctly", before - 1 == after);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of movePaperUp method, of class Modeller.
     */
    @Test
    public void testMovePaperUp() {
        System.out.println("movePaperUp");
        int index = 1;

        int id = instance.getPaper(index).getPaperID();
        instance.movePaperUp(index);

        assertEquals("Paper wasnt moved", id, instance.getPaper(0).getPaperID());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of MovePaperDown method, of class Modeller.
     */
    @Test
    public void testMovePaperDown() {
        System.out.println("MovePaperDown");
        int index = 0;

        int id = instance.getPaper(index).getPaperID();
        instance.MovePaperDown(index);

        assertEquals("Paper wasnt moved", id, instance.getPaper(1).getPaperID());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSubmission method, of class Modeller.
     */
    @Test
    public void testGetNumberOfSubmission() {
        System.out.println("getNumberOfSubmission");

        int expResult = 6;
        int result = instance.getNumberOfSubmission();
        assertEquals("Incorrect number of submissions", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSubmission method, of class Modeller.
     */
    @Test
    public void testGetSubmission() {
        System.out.println("getSubmission");
        int index = 0;

        Submission result = instance.getSubmission(index);
        assertNotNull("Submission incorrectly null", result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of addSubmission method, of class Modeller.
     */
    @Test
    public void testAddSubmission() {
        System.out.println("addSubmission");

        int before = instance.getNumberOfSubmission();
        Submission submission = null;
        instance.addSubmission(submission);
        int after = instance.getNumberOfSubmission();

        assertTrue("Incorrectly added submission", after == before + 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeSubmission method, of class Modeller.
     */
    @Test
    public void testRemoveSubmission() {
        System.out.println("removeSubmission");

        int before = instance.getNumberOfSubmission();
        instance.removeSubmission(before - 1);
        int after = instance.getNumberOfSubmission();

        assertTrue("Incorrectly added submission", after == before - 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}