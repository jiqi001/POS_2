/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.modell;

/**
 *Observer interface.
 *
 */
public interface TotalAmountObserver {
    /**
     * Invoked When the payment is paid, the display will show the total amount of all purchases,
     * since the program started.
     * @param paidAmount  Total cost of a purchase.
     */
    void displayPaidAmount(int paidAmount);
     
}
