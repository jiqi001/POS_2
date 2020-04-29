/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.controller;

import se.kth.iv1350.pos_2.integration.AccountingRegistry;
import se.kth.iv1350.pos_2.integration.ExtenalSystem;
import se.kth.iv1350.pos_2.integration.InventoryRegistry;
import se.kth.iv1350.pos_2.integration.ItemDescriptionDTO;
import se.kth.iv1350.pos_2.integration.Printer;
import se.kth.iv1350.pos_2.modell.CashRegister;
import se.kth.iv1350.pos_2.modell.Payment;
import se.kth.iv1350.pos_2.modell.Receipt;
import se.kth.iv1350.pos_2.modell.SaleInformation;



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
    private InventoryRegistry inventoryRegistry;
    private AccountingRegistry accountingRegistry;
    private Printer printer;
    private ExtenalSystem extenalSystem;
   
    /**
     * Starts a new sale, this is a start point of whole saleprocess.
     */
    public void startSale(){
        this.saleInformation = new SaleInformation();
    }
    /**
     * Uppdate the information about a sale when a new item is scanned. When the item exists
     * then adds the item, otherwise send a message about the invalid item.
     * @param scannedItem The item will be bought by customer.
     */

    public void uppdateSaleInformation(ItemDescriptionDTO scannedItem){
    	InventoryRegistry inventoryRegistry = new InventoryRegistry();
        ItemDescriptionDTO validItem = inventoryRegistry.getItem(scannedItem);
     
        if(validItem!=null){
            saleInformation.saveScannedItem(validItem);
        } 
        if(validItem==null){
        System.out.println("Invalid item");
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
        change = saleInformation.payTotalCost(payment);
        
        accountingRegistry = new AccountingRegistry();
        accountingRegistry.bookSale(saleInformation);
        
        InventoryRegistry inventoryRegistry = new InventoryRegistry();
        inventoryRegistry.decreaseQuantityOfSoldItem(saleInformation);
        
        receipt = new Receipt(saleInformation);
        printer = new Printer();
        printer.getReceipt(receipt);
        
        cashRegister=new CashRegister();
        cashRegister.addPayment(payment);
        
        setnull();
     
        return change;
        
    }
/**
 * clear the sale when it is finshed.
 */
    public void setnull(){
        this.saleInformation = null;         
    }   
}
