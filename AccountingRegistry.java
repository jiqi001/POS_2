/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;


import java.util.HashMap;
import se.kth.iv1350.pos_2.modell.SaleInformation;

/**
 *This is a database for every paid sale.
 *
 */
public class AccountingRegistry {
    private HashMap <String,SaleInformation> saleData = new HashMap<>();
           
    
    public AccountingRegistry(){
        
    }
    /**
     * store a sale in Accouting database,when the sale is paid by customer.
     * @param saleInformation The information about a whole sale.
     */
    public void bookSale(SaleInformation saleInformation){
        saleData.put(saleInformation.getLocalTime(), saleInformation);
        System.out.println("The sale is booked ");
    }
    
    public HashMap <String,SaleInformation> getSaleData(){
       
        return saleData;
    }    
}
