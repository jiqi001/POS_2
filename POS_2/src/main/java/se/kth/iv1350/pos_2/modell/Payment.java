
package se.kth.iv1350.pos_2.modell;

/**
 * Representing one specific payment for one specific sale, customer
 * paid with cash.
 */
public class Payment {
    private final int paidAmount;
/**
 * Create a new instance of payment.
 * @param paidAmount The amount of cash received from customer.
 */
    public Payment(int paidAmount){
        this.paidAmount = paidAmount; 
    }
    public int getPaidAmount(){
        return this.paidAmount;
    }
    
}
