
package se.kth.iv1350.pos_2.integration;

import se.kth.iv1350.pos_2.modell.Receipt;

public class Printer {
    
    public Printer(){
    	
    }
/**
 * print the receipt
 * @param receipt 
 */
        
    public void getReceipt(Receipt receipt){
        System.out.println(receipt.receiptToString());
        
    }
    
}
