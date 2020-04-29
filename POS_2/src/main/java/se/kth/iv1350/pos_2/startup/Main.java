/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.startup;

import se.kth.iv1350.pos_2.controller.Controller;
import se.kth.iv1350.pos_2.integration.ExtenalSystem;
import se.kth.iv1350.pos_2.modell.CashRegister;
import se.kth.iv1350.pos_2.view.View;

/**
 *
 * The class Main contains the main method used to start the whole program.
 */
public class Main {

    /**
     * The main method used to start the entire application.
     * @param args 
     */
    public static void main(String[] args){
        ExtenalSystem extenalSystem = new ExtenalSystem();
        CashRegister cashregister = new CashRegister();
        Controller controller = new Controller();
        View view = new View(controller);
        view.runFakeExecution();
       
        
    }
    
    
     
    
    
}