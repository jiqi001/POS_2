/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos_2.integration.ExtenalSystem;
import se.kth.iv1350.pos_2.integration.NoSuchItemException;

/**
 *
 * @author jinglan
 */
public class InventoryDatabaseExceptionTest {
    private Controller contr;
    private ExtenalSystem extenalSystem;
    
    @BeforeEach
    void setUp() {
        extenalSystem= new ExtenalSystem();
        contr= new Controller(extenalSystem);
        
    }
    
    @AfterEach
    void tearDown() {
        contr=null;
        extenalSystem=null;
    }

    @Test
    void testSomeMethod() throws NoSuchItemException {
        int databaseError=999;
        String expected = "InventoryDatabaseError";
        try{
            contr.uppdateSaleInformation(databaseError);
        }
        catch(InventoryDatabaseException excep){
            
        assertEquals(expected,excep.getMessage());
        }
     
    }
    
}
