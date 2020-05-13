/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos_2.controller.Controller;
import se.kth.iv1350.pos_2.controller.InventoryDatabaseException;

/**
 *
 * @author jinglan
 */
public class NoConnectToDatabaseExceptionTest {
    private Controller contr;
    private ExtenalSystem extenalSystem;
    
    
    public NoConnectToDatabaseExceptionTest() {
    }
    
    
    @BeforeEach
    void setUp() {
        extenalSystem= new ExtenalSystem();
        contr = new Controller(extenalSystem);
        
    }
    
    @AfterEach
    void tearDown() {
        contr=null;
        extenalSystem=null;
    }

    @Test
    void testSomeMethod() throws InventoryDatabaseException, NoSuchItemException {
        int ErrorConnectionToDatabase=999;
        String expected ="The Database can not be called" ;
        try{
            contr.uppdateSaleInformation(ErrorConnectionToDatabase);
        }
        catch(InventoryDatabaseException excp){
             assertEquals(expected,excp.getCause().getMessage());
        }
        
    }
    
}
