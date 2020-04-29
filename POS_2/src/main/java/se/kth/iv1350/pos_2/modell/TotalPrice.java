
package se.kth.iv1350.pos_2.modell;

import se.kth.iv1350.pos_2.integration.ItemDescriptionDTO;
/**
 *
 * 
 */
public class TotalPrice {
    private final double totalPrice;
    private final int hundred=100;
    /**
     * calculate the total price of a item included tax.
     * @param validItem item which exist in the inventoryRegistry
     */
    public TotalPrice(ItemDescriptionDTO validItem){
        this.totalPrice=(validItem.getPrice() * validItem.getQuantityOfItem()*
        (validItem.getVAT()+hundred)/hundred);
    }
    
    /**
     * Total price of a item included tax.
     * @return total price included tax of a item.
     */
    public double getTotal(){
        return this.totalPrice;
    }
    
}
