
package se.kth.iv1350.pos_2.integration;


import java.util.HashMap;
import java.util.Iterator;
import se.kth.iv1350.pos_2.modell.SaleInformation;

/**
 * Contains all calls to the data store with items that could be bought.
 */
public class InventoryRegistry {
    private ItemDescriptionDTO validItem;
    private HashMap <Integer,ItemDescriptionDTO> items = new HashMap<>();
    /**
     * Creates a instance of inventory system.
     */
    public InventoryRegistry(){
        addItems();
    }
    
   /**
    * Search for a item which maching the specified search identifier.
    * @param scannedItem The specified item will be bought by customer.
    * @return <code>item</code> if a item in the database has the same 
    * identifier as the <code>scannedItem</code> return the item with 
    * the correct quantity, otherwise return<code>null</code>.
    */
    
    public ItemDescriptionDTO getItem(ItemDescriptionDTO scannedItem){
       
        if(items.containsKey(scannedItem.getIdentifier())){
               
            validItem= items.get(scannedItem.getIdentifier());
            validItem.setQuantityOfItem(scannedItem.getQuantityOfItem());
               
            return validItem;
        }
        return null;
    }
   /**
    * When a payment is paid by a customer, quantity of sold item
    * will be update in the database.
    * @param saleInformation contains all information about a sale.
    */
    public void decreaseQuantityOfSoldItem(SaleInformation saleInformation){
    	
        Iterator<Integer> iterator = saleInformation.getScannedItems().keySet().iterator();
       
        while(iterator.hasNext()){
           int identifier = iterator.next();
           
            if(items.containsKey(identifier)){
                int uppdateQuantity =items.get(identifier).getQuantityOfItem() -
                    saleInformation.getScannedItems().get(identifier).getQuantityOfItem();
                
                items.get(identifier).setQuantityOfItem(uppdateQuantity);
                System.out.println("Sold item is updated in InventoryRegistry");
            }  
            
            else {
            System.out.println("The item does not exist in the invetory system");
            }
        }
    }
    
    public int getQuantityInDatabase(int identifier){
        return items.get(identifier).getQuantityOfItem();
    }  
    
    private void addItems(){
       items.put(111,new ItemDescriptionDTO(111, 10.00, 25, "Glass",10));
       items.put(222,new ItemDescriptionDTO(222, 20.89, 25, "mjölk",10));
       items.put(333,new ItemDescriptionDTO(333, 2.89, 25, "jäst",10));
    }
    
   

    
}
