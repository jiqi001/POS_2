/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;

/**
 *
 * creates a new instance of the exception, the exception will be thrown 
 * when the searched identifier nr does not exist in the inventoryRegistry.
 */
public class NoSuchItemException extends Exception{
    
    public NoSuchItemException(int identifier){
        super( "The item with the identifier nr " + identifier + " does not exist in the inventory.");
    
    }
    
}
