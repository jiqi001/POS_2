/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos_2.integration.ExtenalSystem;
import se.kth.iv1350.pos_2.integration.ItemDescriptionDTO;
import se.kth.iv1350.pos_2.integration.NoConnectToDatabaseException;
import se.kth.iv1350.pos_2.integration.NoSuchItemException;
import se.kth.iv1350.pos_2.modell.CashRegister;
import se.kth.iv1350.pos_2.modell.Payment;
import se.kth.iv1350.pos_2.modell.Receipt;
import se.kth.iv1350.pos_2.modell.SaleInformation;
import se.kth.iv1350.pos_2.modell.TotalAmountObserver;



/**
 *This is the applications controller, all calls to the model pass through this class.
 * 
 */
public class Controller {
    private SaleInformation saleInformation;
    private Payment payment;
    private int change;
    private CashRegister cashRegister;
    private Receipt receipt;
    private ExtenalSystem extenalSystem;
    private List <TotalAmountObserver> observers=new ArrayList<>();
    
    public Controller(ExtenalSystem extenalSystem){
        this.extenalSystem=extenalSystem;
        
    }
   
    /**
     * Starts a new sale, this is a start point of whole saleprocess.
     */
    public void startSale(){
        this.saleInformation = new SaleInformation();
        
    }
    /**
     * Update the information about a sale when a new item is scanned.When the item exists
     * in the inventoryRegistry, the item will be saved, otherwise throws exceptions.
     * @param identifier barcode of a specific item.
     * @throws InventoryDatabaseException, if failed to connect the database of the inventoryRegistry.
     * @throws NoSuchItemException, if the searched identifier does not exist in the inventoryRegistry.
     */

    public void uppdateSaleInformation(int identifier) throws InventoryDatabaseException, NoSuchItemException {
        ItemDescriptionDTO scannedItem = new ItemDescriptionDTO(identifier);
        
        try{ 
            ItemDescriptionDTO validItem = extenalSystem.getInventoryRegistry().getItem(scannedItem);
            if(validItem!=null&& validItem.getIdentifier()!=999)
            saleInformation.saveScannedItem(validItem);
        }
        
        catch(NoConnectToDatabaseException msg){
            throw new InventoryDatabaseException("InventoryDatabaseError",msg);
        }
       
    }
 /**
  * Customer pay the payment, then sale information is send to external accounting system 
  * for accounting and external inventory system to update inventory, and creates and
  * print the receipt.

  * @param paidAmount the amount of cash receives from customer.
  * @return the amount change.
  */
    
    public int pay(int paidAmount){
        payment = new Payment(paidAmount);
        saleInformation.addPaidAmount(observers);
        change = saleInformation.payTotalCost(payment);
        extenalSystem.getAccoutingRegistry().bookSale(saleInformation);
        
        receipt = new Receipt(saleInformation);
        extenalSystem.getPrinter().getReceipt(receipt);
        
        cashRegister=new CashRegister();
        cashRegister.addPayment(payment);
        setnull();
     
        return change;
        
    }
    /**
     * clear the sale when it is finished.
     */
    public void setnull(){
        this.saleInformation = null;         
    }
    /**
     * Add the object of TotalAmountObserver to the array list observers.
     * @param obj 
     */
    public void addObserver(TotalAmountObserver obj){
        observers.add(obj);
     
    }

    
}
