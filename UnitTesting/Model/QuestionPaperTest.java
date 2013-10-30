/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.Section;
import Model.questionPaper.QuestionPaper;
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
public class QuestionPaperTest {

    private static QuestionPaper instance;

    public QuestionPaperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new QuestionPaper(1);
        instance.setTitle("Title");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        for (int i = 0; i<instance.getNumberOfSections(); i++)
            instance.removeSection(i);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addEligibleStudent method, of class QuestionPaper.
     */
    @Test
    public void testAddEligibleStudent() {
        System.out.println("addEligibleStudent");
        int ID = 1010101010;
        instance.addEligibleStudent(ID);

        assertTrue("Student eligibility unchanged", instance.isStudentEligible(ID));

        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of addEligibleStudents method, of class QuestionPaper.
     */
    @Test
    public void testAddEligibleStudents() {
        System.out.println("addEligibleStudents");
        int[] IDs = new int[2];
        IDs[0] = 98;
        IDs[1] = 99;

        instance.addEligibleStudents(IDs);

        assertTrue("Students not added to eligibility lists", instance.isStudentEligible(98)
                && instance.isStudentEligible(99));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of addEligibleSetter method, of class QuestionPaper.
     */
    @Test
    public void testAddEligibleSetter() {
        System.out.println("addEligibleSetter");
        int ID = 102;
        
        instance.addEligibleSetter(ID);
        
        assertTrue("Setter eligibility unchanged", instance.isSetterEligible(ID));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of addEligibleSetters method, of class QuestionPaper.
     */
    @Test
    public void testAddEligibleSetters() {
        System.out.println("addEligibleSetters");
        int[] IDs = new int[2];
        IDs[0] = 98;
        IDs[1] = 99;

        instance.addEligibleSetters(IDs);

        assertTrue("Setters not added to eligibility lists", instance.isSetterEligible(98)
                && instance.isSetterEligible(99));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class QuestionPaper.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "Title";
        
        instance.setTitle(title);
        
        assertTrue("Title unchanged", title.equals(instance.getTitle()));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class QuestionPaper.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        
        String description = "Description";
        
        instance.setDescription(description);
        
        assertEquals("Description unchanged", description, instance.getDescription());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setInstructions method, of class QuestionPaper.
     */
    @Test
    public void testSetInstructions() {
        System.out.println("setInstructions");
        String instructions = "Instructions";
        
        instance.setInstructions(instructions);
        
        assertEquals("Instructions unchanged", instructions, instance.getInstructions());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPaperID method, of class QuestionPaper.
     */
    @Test
    public void testGetPaperID() {
        System.out.println("getPaperID");
        
        int expResult = 1;
        int result = instance.getPaperID();
        assertEquals("Paper ID not as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class QuestionPaper.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        
        String expResult = "Title";
        String result = instance.getTitle();
        assertEquals("Title not as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class QuestionPaper.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        
        String expResult = "Description";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals("Description not as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getInstructions method, of class QuestionPaper.
     */
    @Test
    public void testGetInstructions() {
        System.out.println("getInstructions");
        
        String expResult = "Instructions";
        instance.setInstructions(expResult);
        String result = instance.getInstructions();
        assertEquals("Instructions not as expected", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSections method, of class QuestionPaper.
     */
    @Test
    public void testGetNumberOfSections() {
        System.out.println("getNumberOfSections");
        
        int expResult = 0;
        int result = instance.getNumberOfSections();
        System.out.println("#Sections: " + result);
        assertEquals("Incorrect number of sections", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSection method, of class QuestionPaper.
     */
    @Test
    public void testGetSection() {
        System.out.println("getSection");
        int ID = 0;
        
        Section section = null;
        instance.addSection(section);
        
        Section result = instance.getSection(ID);
        assertNull("Something is wrong", result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSectionList method, of class QuestionPaper.
     */
    @Test
    public void testGetSectionList() {
        System.out.println("getSectionList");
        
        instance.addSection(null);
        
        ArrayList result = instance.getSectionList();
        assertTrue("Incorrect Length", result.size() == 1);
        assertNull("Incorrect data", result.get(0));
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of removeSection method, of class QuestionPaper.
     */
    @Test
    public void testRemoveSection() {
        System.out.println("removeSection");
        int position = 0;
        
        if (instance.getNumberOfSections() > 0) 
            instance.removeSection(position);
        else {
            instance.addSection(new Section(1, null, null, null, position));
            instance.removeSection(0);
        }
        int result = instance.getNumberOfSections();
        assertTrue ("Was not removed", result == 0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of moveSectionUp method, of class QuestionPaper.
     */
    @Test
    public void testMoveSectionUp() {
        System.out.println("moveSectionUp");
        
        Section s1 = new Section(1, null, null, null, 1);
        Section s2 = new Section(2, null, null, null, 1);
        
        instance.addSection(s1);
        instance.addSection(s2);
        
        instance.moveSectionUp(1);
        
        assertTrue("Section wasn't moved", instance.getSection(0).getID() == 2);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of moveSectionDown method, of class QuestionPaper.
     */
    @Test
    public void testMoveSectionDown() {
        System.out.println("moveSectionDown");
        
        Section s1 = new Section(1, null, null, null, 1);
        Section s2 = new Section(2, null, null, null, 1);
        
        instance.addSection(s1);
        instance.addSection(s2);
        
        instance.moveSectionDown(0);
        
        assertTrue("Section wasn't moved", instance.getSection(1).getID() == 1);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}