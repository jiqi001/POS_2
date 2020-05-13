/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;

/**
 *
 * creates a new instance of the exception, the exception will be thrown when
 * the database can not be called.
 */
public class NoConnectToDatabaseException extends RuntimeException {
    public NoConnectToDatabaseException(){
        super("The Database can not be called");
    }
    
}
