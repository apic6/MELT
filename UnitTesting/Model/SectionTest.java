/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.questionPaper.Section;
import Model.questionPaper.SubSection;
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
public class SectionTest {

    private static Section instance;

    public SectionTest() {
        instance = new Section(1, "Title", "Description", "Instructions", 1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        for (int i = 0; i < instance.getNumberOfSubSections(); i++) {
            instance.RemoveSubSection(i);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setTitle method, of class Section.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String Title = "title1";

        instance.setTitle(Title);

        assertEquals("title unchanged", Title, instance.getTitle());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Section.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String Description = "Description1";

        instance.setDescription(Description);

        assertEquals("Description unchanged", Description, instance.getDescription());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setInstructions method, of class Section.
     */
    @Test
    public void testSetInstructions() {
        System.out.println("setInstructions");
        String Instructions = "Instructions";

        instance.setTitle(Instructions);

        assertEquals("Instructions unchanged", Instructions, instance.getInstructions());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeLimit method, of class Section.
     */
    @Test
    public void testSetTimeLimit() {
        System.out.println("setTimeLimit");
        int TimeLimit = 101;

        instance.setTimeLimit(TimeLimit);

        assertEquals("Time limit unchanged", TimeLimit, instance.getTimeLimit());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Section.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");

        int expResult = 1;
        int result = instance.getID();
        assertEquals("ID returned wrongly", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Section.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");

        String expResult = "Title";
        String result = instance.getTitle();
        assertEquals("Title incorrect", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Section.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");

        String expResult = "Description";
        String result = instance.getDescription();
        assertEquals("Description incorrect", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getInstructions method, of class Section.
     */
    @Test
    public void testGetInstructions() {
        System.out.println("getInstructions");

        String expResult = "Instructions";
        String result = instance.getInstructions();
        assertEquals("Instructions incorrect", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeLimit method, of class Section.
     */
    @Test
    public void testGetTimeLimit() {
        System.out.println("getTimeLimit");

        int expResult = 1;
        int result = instance.getTimeLimit();
        assertEquals("Time limit incorrect", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSubSections method, of class Section.
     */
    @Test
    public void testGetNumberOfSubSections() {
        System.out.println("getNumberOfSubSections");

        int expResult = 0;
        int result = instance.getNumberOfSubSections();
        assertEquals("Number of sections incorrect", expResult, result);

        instance.AddSubSection(null);
        instance.AddSubSection(null);

        expResult = 2;
        result = instance.getNumberOfSubSections();
        assertEquals("Number of sections incorrect", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSubSection method, of class Section.
     */
    @Test
    public void testGetSubSection() {
        System.out.println("getSubSection");

        instance.AddSubSection(null);

        int ID = 0;

        SubSection expResult = null;
        SubSection result = instance.getSubSection(ID);

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getSubSections method, of class Section.
     */
    @Test
    public void testGetSubSections() {
        System.out.println("getSubSections");

        instance.AddSubSection(null);
        instance.AddSubSection(null);
        instance.AddSubSection(null);


        ArrayList result = instance.getSubSections();
        assertEquals("Incorrectly returned list", result.size(), 3);
        assertEquals("Incorrectly returned list", result.get(0), null);
        assertEquals("Incorrectly returned list", result.get(1), null);
        assertEquals("Incorrectly returned list", result.get(2), null);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of AddSubSection method, of class Section.
     */
    @Test
    public void testAddSubSection_int_SubSection() {
        System.out.println("AddSubSection");
        int position = 0;
        SubSection S = null;

        instance.AddSubSection(position, S);
        assertNull("Incorrectly added subsections", instance.getSubSection(0));

        SubSection S2 = new SubSection("Title", "Desc", "instr");

        instance.AddSubSection(0, S2);

        assertNotNull("Incorrectly added subsections", instance.getSubSection(0));


        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of AddSubSection method, of class Section.
     */
    @Test
    public void testAddSubSection_SubSection() {
        System.out.println("AddSubSection");
        SubSection S = null;

        instance.AddSubSection(S);
        assertNull("Incorrectly added subsections", instance.getSubSection(0));

        SubSection S2 = new SubSection("Title", "Desc", "instr");

        instance.AddSubSection(S2);

        assertNotNull("Incorrectly added subsections", instance.getSubSection(1));
        
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveSubSection method, of class Section.
     */
    @Test
    public void testRemoveSubSection() {
        System.out.println("RemoveSubSection");
        SubSection S = null;

        instance.AddSubSection(S);
        assertNull("Incorrectly added subsections", instance.getSubSection(0));

        SubSection S2 = new SubSection("Title", "Desc", "instr");

        instance.AddSubSection(S2);

        assertNotNull("Incorrectly added subsections", instance.getSubSection(1));

        instance.RemoveSubSection(0);

        assertNotNull("Incorrectly Removed subsections", instance.getSubSection(0));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of MoveSubSectionUp method, of class Section.
     */
    @Test
    public void testMoveSubSectionUp() {
        System.out.println("MoveSubSectionUp");

        SubSection S = null;
        instance.AddSubSection(S);
        
        SubSection S2 = new SubSection("Title", "Desc", "instr");
        instance.AddSubSection(S2);
        
        
        
        instance.MoveSubSectionUp(1);
        
        assertNotNull("Incorrectly moved", instance.getSubSection(0));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of MoveSubSectionDown method, of class Section.
     */
    @Test
    public void testMoveSubSectionDown() {
        System.out.println("MoveSubSectionDown");
        
        SubSection S = null;
        instance.AddSubSection(S);
        
        SubSection S2 = new SubSection("Title", "Desc", "instr");
        instance.AddSubSection(S2);
        
        
        
        instance.MoveSubSectionDown(0);
        
        assertNull("Incorrectly moved", instance.getSubSection(1));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}