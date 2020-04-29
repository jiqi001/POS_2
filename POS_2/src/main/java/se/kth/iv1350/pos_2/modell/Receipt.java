/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.modell;

import se.kth.iv1350.pos_2.integration.ExtenalSystem;
import se.kth.iv1350.pos_2.integration.Printer;


/**
 *
 *The receipt of a payment.
 */
public class Receipt {
    private ExtenalSystem extenalSystem;
    private Receipt receipt;
    private SaleInformation saleInformation;
    private Printer printer;
    /**
     * Create a new instance of a receipt.
     * @param saleInformation  the information about a sale.
     */
    public Receipt(SaleInformation saleInformation){
    	
        this.saleInformation = saleInformation;
  
    }
    /**
     * Represent a receipt.
     * @return the text on a receipt.
     */
    
    public String receiptToString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Receipt");
        sb.append("\n");
        sb.append("Saletime ").append(saleInformation.getLocalTime());
        sb.append("\n");
    
        sb.append(saleInformation.getScannedItems().values().toString());
        sb.append("\n");
        sb.append("Average VAT").append(saleInformation.getAverageVAT());
        sb.append("%");
        sb.append("\n");
        sb.append("Total Cost: ").append(saleInformation.getTotal());
        sb.append("kr ");
        sb.append("Paid:").append(saleInformation.getPaidAmount());
        sb.append("kr ");
        sb.append("Change : ").append(saleInformation.getchange());
        sb.append("kr");
        
        return sb.toString();
    }
    
}
