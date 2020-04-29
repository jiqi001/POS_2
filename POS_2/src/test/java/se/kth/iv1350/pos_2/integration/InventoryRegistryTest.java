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
import se.kth.iv1350.pos_2.modell.SaleInformation;

/**
 *
 * @author jinglan
 */
public class InventoryRegistryTest {
    private ItemDescriptionDTO jäst ;
    private ItemDescriptionDTO mjölk;
    private ItemDescriptionDTO chips;
    private InventoryRegistry inventory;
    private SaleInformation sale;
    private int seven;
    public InventoryRegistryTest() {
    }
    
 
    
    @BeforeEach
    void setUp() {
        jäst=new ItemDescriptionDTO(333);
        mjölk=new ItemDescriptionDTO(222, 20.89, 25, "mjölk",3);
        chips = new ItemDescriptionDTO(123);
        inventory=new InventoryRegistry();
        sale = new SaleInformation();
        seven =7;
 
        
    }
    
    @AfterEach
    void tearDown() {
        jäst=null;
        mjölk=null;
        chips =null;
        inventory=null;
        sale = null;

    }

    /**
     * Test of getItem method, of class InventoryRegistry.
     */
    @Test
    void testGetItemNull() {
        inventory.getItem(chips);
        assertEquals(inventory.getItem(chips), null,"return null is failed"
                + "when item does not exist in inventory");
       
    }
    @Test
    void testGetItem() {
        inventory.getItem(mjölk);
        assertEquals(inventory.getItem(mjölk).toString(), mjölk.toString(),
                "The method getitem failed");
       
    }
    

    /**
     * Test of decreaseQuantityOfSoldItem method, of class InventoryRegistry.
     */
    @Test
    void testDecreaseQuantityOfSoldItem() {
        sale.saveScannedItem(mjölk);
        inventory.decreaseQuantityOfSoldItem(sale);
        assertTrue(inventory.getQuantityInDatabase(mjölk.getIdentifier())==seven,
                "The method decreaseQuantityOfItem failed");
     
      
    }
    
    
}
