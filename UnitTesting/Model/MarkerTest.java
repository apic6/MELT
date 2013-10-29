/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.Section;
import Model.questionPaper.MultipleChoiceQuestion;
import Model.questionPaper.SubSection;
import Model.questionPaper.QuestionPaper;
import Model.StudentSubmission.MCQAnswer;
import Model.StudentSubmission.SubmissionSubSection;
import Model.StudentSubmission.Submission;
import Model.StudentSubmission.SubmissionSection;
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
public class MarkerTest {

    private static Submission submission;
    private static QuestionPaper paper;
    private static Marker instance;

    public MarkerTest() {
        paper = new QuestionPaper(1);
        submission = new Submission(1, 101);

        Section section = new Section(1, "Section 1", "Desc", "Inst", 10);
        SubSection sSection = new SubSection("Sub Section 1", "Desc", "Inst");

        String[] answers = new String[2];
        answers[0] = "0";
        answers[1] = "1";

        int[] possibleAnswers = new int[1];
        possibleAnswers[0] = 1;

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Q?", answers, "Inst", possibleAnswers, 1);

        sSection.addQuestion(question);
        section.AddSubSection(sSection);
        paper.addSection(section);

        submission.addSection(new SubmissionSection(1));
        submission.getSection(0).addSubSection(new SubmissionSubSection(1));
        submission.getSection(0).getSubSection(0).addAnswer(new MCQAnswer(0, 1));
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new Marker();
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
     * Test of markTest method, of class Marker.
     */
    @Test
    public void testMarkTest_StudentSubmission_QuestionPaper() {
        System.out.println("markTest");


        boolean expResult = true;
        boolean result = instance.markTest(submission, paper);
        assertEquals("IDs fail to match something strange happened", expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getMark method, of class Marker.
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
     * Test of getTotalMark method, of class Marker.
     */
    @Test
    public void testGetTotalMark() {
        System.out.println("getTotalMark");

        instance.markTest(submission, paper);
        int expResult = 1;
        int result = instance.getTotalMark();

        assertEquals("Total mark isn't as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}