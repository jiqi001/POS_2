/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.view;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos_2.modell.TotalAmountObserver;

/**
 * The class implements Observer and represent a display that shows the total
 * amount paid for purchases, since the program started.
 */
public class TotalRevenueView implements TotalAmountObserver {
    private int TotalAmount;
    private List <Integer> paidPayment= new ArrayList();
   

    @Override
    public void displayPaidAmount(int paidAmount) {
        paidPayment.add(paidAmount);
        TotalAmount+= paidAmount;
        display();
    }
    /**
     * Print the total amount paid for purchases on the screen.
     */
    
     private void display(){
        System.out.println("--------------Total Paid Amount Display--------------");
        System.out.println("\n The accumulated total paid amount is : 3"+TotalAmount);
        System.out.println("\n The payment list:"+paidPayment.toString());
        System.out.println("----------------------------------------------------");
    }
    
    
}
