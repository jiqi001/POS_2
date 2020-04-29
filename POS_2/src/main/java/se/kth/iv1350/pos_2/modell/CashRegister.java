/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.modell;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This is cash Register, every paid amount it stored here.
 */
public class CashRegister {
    private int totalCash;
    private List <Integer> cashdata = new ArrayList<>();
    
    public CashRegister(){
        
    }
    /**
     * CashRegister add a payment, when the payment is paid.
     * @param payment 
     */
    
    public void addPayment(Payment payment){
        cashdata.add(payment.getPaidAmount());
        totalCash += payment.getPaidAmount();
    }
    
}
