/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.view;

import se.kth.iv1350.pos_2.controller.Controller;
import se.kth.iv1350.pos_2.integration.ItemDescriptionDTO;

/**
 *
 * This is a placeholder for the View, the program has no executional view.
 */
public class View {
    private Controller controller;
/**Creates a new instance, and uses the specified controller to call methods in other layers.
 * 
 * @param controller the controller uses to call methods in the other layers.
 */    
    public View(Controller controller){
        this.controller= controller;
    }
    public void runFakeExecution(){
        ItemDescriptionDTO item = new ItemDescriptionDTO(111, 10.00, 25, "Glass",4);
        ItemDescriptionDTO anotherItem = new ItemDescriptionDTO(222);
        controller.startSale();
        System.out.println("A new sale has been started");
        controller.uppdateSaleInformation(item);
        controller.uppdateSaleInformation(anotherItem);
        System.out.println("Item has been scanned");
        controller.pay(100);
        System.out.println("Payment is paid");
    }
    
    
    
}
