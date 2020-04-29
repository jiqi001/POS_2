/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;

/**
 *This class is responsible for instantiating all extenal systems.
 */
public class ExtenalSystem {
    private InventoryRegistry inventoryRegistry;
    private Printer printer;
    private AccountingRegistry accountingRegistry;
    
    public ExtenalSystem(){
        this.inventoryRegistry=inventoryRegistry;
        this.printer=printer;
        this.accountingRegistry=accountingRegistry;
    }
    /**
     * Get inventoryRegistry
     * @return the value of inventoryRegistry
     */
    public InventoryRegistry getInventoryRegistry(){
        return inventoryRegistry;  
    }
    
    public Printer getPrinter(){
        return printer;
    }
    
    public AccountingRegistry getAccoutingRegistry(){
        return accountingRegistry;
    }
    
    
}
