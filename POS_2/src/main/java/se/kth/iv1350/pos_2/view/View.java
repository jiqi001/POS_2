/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.view;

import se.kth.iv1350.pos_2.controller.Controller;
import se.kth.iv1350.pos_2.controller.InventoryDatabaseException;

import se.kth.iv1350.pos_2.integration.NoSuchItemException;

/**
 *
 * This is a placeholder for the View.
 */
public class View {
    private Controller controller;
    private ExceptionHandler log;

/**Creates a new instance, and uses the specified controller to call methods in other layers.
 * 
 * @param controller the controller uses to call methods in the other layers.
     * @param log log and send exception message.
 */    
    public View(Controller controller,ExceptionHandler log){
        this.controller= controller;
        this.log = log;
        controller.addObserver(new TotalRevenueView());
      
    }
    
    
    public void runFakeExecution() throws NoSuchItemException, 
        InventoryDatabaseException{
        int glass = 111;
        int mjölk = 222;
        int noSuchItem = 444;
        int DatabaseError=999;
        controller.startSale();
        System.out.println("A new sale has been started");
       
        try{
            controller.uppdateSaleInformation(glass);
            controller.uppdateSaleInformation(mjölk);
        }
        catch(NoSuchItemException |InventoryDatabaseException msg ){
            ShowException(msg);
        }
        try{
            
            controller.uppdateSaleInformation(noSuchItem);
            
        }
        
        catch(NoSuchItemException |InventoryDatabaseException msg ){
            ShowException(msg);
            
        }
        try{
            controller.uppdateSaleInformation(DatabaseError);
        }
        catch(NoSuchItemException |InventoryDatabaseException msg){
            ShowException(msg);
        }
        controller.pay(100);
        System.out.println("\nPayment is paid");
        
        
    }
    /**
     * show the exception messeage on the screen.
     * @param excp exception
     */
     private void ShowException(Exception excp){
        log.showExceptionMessage(excp); 
        log.logException(excp);
        
    }
    
    
}
