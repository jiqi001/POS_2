/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.controller;

/**
 *creates a new instance of the exception, the exception will be thrown when
 * it catches NoConnectToDatabaseException.
 */
public class InventoryDatabaseException extends Exception{
    public InventoryDatabaseException(String msg,Exception cause){
        super(msg,cause);
        
    }
    
}
