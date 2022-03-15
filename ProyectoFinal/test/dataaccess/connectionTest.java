/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author infan
 */
public class connectionTest {
    
    public connectionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of prepareStatement method, of class connection.
     */
    @Test
    public void testPrepareStatement() {
        System.out.println("prepareStatement");
        String sql = "";
        PreparedStatement expResult = null;
        PreparedStatement result = connection.prepareStatement(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareCall method, of class connection.
     */
    @Test
    public void testPrepareCall() {
        System.out.println("prepareCall");
        String sql = "";
        CallableStatement expResult = null;
        CallableStatement result = connection.prepareCall(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
