/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanical_parts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class TreeTest {
    
    public TreeTest() {
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
     * Test of findRoot method, of class Tree.
     */
    @Test
    public void testFindRoot() {
        System.out.println("findRoot");
        Tree instance = new Tree();
        String expResult = "";
        String result = instance.findRoot();
        assertEquals(expResult, result);
    }

    /**
     * Test of find method, of class Tree.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String key = "";
        Tree instance = new Tree();
        instance.find(key);
    }

    /**
     * Test of add method, of class Tree.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String data = "";
        Tree instance = new Tree();
        instance.add(data);
    }

    /**
     * Test of resetTree method, of class Tree.
     */
    @Test
    public void testResetTree() {
        System.out.println("resetTree");
        Tree instance = new Tree();
        instance.resetTree();
    }

    /**
     * Test of displayTree method, of class Tree.
     */
    @Test
    public void testDisplayTree() {
        System.out.println("displayTree");
        Tree instance = new Tree();
        instance.displayTree();
    }

    /**
     * Test of delete method, of class Tree.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String selectedNode = "";
        Tree instance = new Tree();
        instance.delete(selectedNode);
    }
    
}
