/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * 
 */
public class ItemDescriptionDTOTest {
    private ItemDescriptionDTO itemToTest;
    private ItemDescriptionDTO anotherItemToTest;
    private int identifier;
    private int anotherIdentifier;
    private int one;
    private double price;
    private int VAT;
    private String nameOfItem;
    private int quantity;
    private String toString;
    private double anotherPrice;
    
    
    public ItemDescriptionDTOTest() {
    }
    

    @BeforeEach
    void setUp() {
        nameOfItem="Glass";
        quantity = 2;
        VAT=25;
        price= 10.00;
        one =1;
        identifier = 111;
        anotherIdentifier=222;
        toString=nameOfItem+" "+quantity+"st"+" "+price+"kr"+" "+VAT+"%";
        itemToTest = new ItemDescriptionDTO(identifier,price, VAT, nameOfItem,quantity);
        anotherItemToTest = new ItemDescriptionDTO(anotherIdentifier);
        
        
    }
    
    @AfterEach
    void tearDown() {
        nameOfItem= null;
        toString=null;
        itemToTest=null;
        anotherItemToTest =null;
    }

    /**
     * Test of setQuantityOfItem method, of class ItemDescriptionDTO.
     */
    @Test
    void testSetQuantityOfItem() {
        int four = 4;
        itemToTest.setQuantityOfItem(four);
        assertTrue(itemToTest.getQuantityOfItem()==four,"The method setQuantityOfItem failed");
    }

    /**
     * Test of getQuantityOfItem method, of class ItemDescriptionDTO.
     */
    @Test
    void testGetQuantityOfItem() {
        itemToTest.getQuantityOfItem();
        assertTrue(itemToTest.getQuantityOfItem()==quantity, "Quantity of the item wrong, "
                + "the method getQauntityOfItem failed ");
    
    }
    /**
     * Test of if the quantity of Item is set to be one.
     */
    @Test
    void testQuantityOfItemIsSettoOne(){
        anotherItemToTest.getQuantityOfItem();
        assertTrue(anotherItemToTest.getQuantityOfItem()==one, "The quantity of a item is not set to be one.");
        
    }

    /**
     * Test of getIdentifier method, of class ItemDescriptionDTO.
     */
    @Test
    void testGetIdentifier(){
        assertTrue(itemToTest.getIdentifier()==identifier, "Wrong idenfitier number");
       
    }

    /**
     * Test of getPrice method, of class ItemDescriptionDTO.
     */
    @Test
    void testGetPrice() {
        assertTrue(itemToTest.getPrice()== price,"The price of the Item is wrong");

    }

    /**
     * Test of getVAT method, of class ItemDescriptionDTO.
     */
    @Test
    public void testGetVAT() {
    
        assertTrue(itemToTest.getVAT()==VAT, "The VAT of Item is Wrong ");
      
    }

    /**
     * Test of toString method, of class ItemDescriptionDTO.
     */
    @Test
    public void testToString() {
    
        assertEquals(itemToTest.toString(),toString, "The method toString failed");
     
    }
    
}
