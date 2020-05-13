/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos_2.controller.Controller;
import se.kth.iv1350.pos_2.controller.InventoryDatabaseException;


/**
 *
 * @author jinglan
 */
public class NoSuchItemExceptionTest {
    private Controller contr;
    private ExtenalSystem extenalSystem;
    
   
    
    @BeforeEach
    void setUp() {
        extenalSystem=new ExtenalSystem();
        contr= new Controller(extenalSystem);
        
    }
    
    @AfterEach
    void tearDown() {
        contr=null;
        extenalSystem=null;
    }

    @Test
    void testSomeMethod() throws NoSuchItemException, InventoryDatabaseException {
        int invalidIdentifier=777;
        String expected="The item with the identifier nr " + invalidIdentifier + " does not exist in the inventory.";
        try{
            contr.uppdateSaleInformation(invalidIdentifier);
        }
        catch(NoSuchItemException excp){
            assertEquals(expected,excp.getMessage());
            
        }
        
    }
    
}
