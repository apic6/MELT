/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.StudentSubmission;

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
public class SubmissionSubSectionTest {

    SubmissionSubSection instance1;
    SubmissionSubSection instance2;

    public SubmissionSubSectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance1 = new SubmissionSubSection(1);
        instance2 = new SubmissionSubSection(2);

        String[] answers = new String[2];
        answers[0] = "";
        answers[1] = "";

        int[] pAnswers = new int[2];
        pAnswers[0] = 0;
        pAnswers[1] = 1;

        instance1.addAnswer(new MCQAnswer(1, 1));
        instance2.addSubSection(new SubmissionSubSection(3));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addAnswer method, of class SubmissionSubSection.
     */
    @Test
    public void testAddAnswer() {
        System.out.println("addAnswer");

        boolean result = instance1.addAnswer(new MCQAnswer(1, 1));
        assertTrue("cannot add answer to answer collection", result);

        result = instance2.addAnswer(new MCQAnswer(1, 1));
        assertFalse("can add answer to subsection collection", result);
    }

    /**
     * Test of addSubSection method, of class SubmissionSubSection.
     */
    @Test
    public void testAddSubSection() {
        System.out.println("addSubSection");

        boolean result = instance1.addSubSection(new SubmissionSubSection(1));
        assertFalse("can add subSection to answer collection", result);

        result = instance2.addSubSection(new SubmissionSubSection(1));
        assertTrue("Cannot add subSection to subsection collection", result);
    }

    /**
     * Test of getAnswer method, of class SubmissionSubSection.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");

        Answer result = instance2.getAnswer(0);
        assertNull("Subsection returned null", result);

        result = instance1.getAnswer(0);
        assertNotNull("Subsection returned null", result);
    }

    /**
     * Test of getSubSection method, of class SubmissionSubSection.
     */
    @Test
    public void testGetSubSection() {
        System.out.println("getSubSection");

        SubmissionSubSection result = instance2.getSubSection(0);
        assertNotNull("Subsection returned null", result);

        result = instance1.getSubSection(0);
        assertNull("Subsection returned null", result);
    }
}