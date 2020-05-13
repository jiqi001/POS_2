package se.kth.iv1350.pos_2.modell;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import se.kth.iv1350.pos_2.integration.ItemDescriptionDTO;

/**
 * One singel saleinformation is created by one singel purchasing. The saleinformation
 * is consist of information about items.
 * 
 * 
 */
public class SaleInformation{
    private final LocalTime saleTime;
    private final LocalDate saleDate;
    private HashMap<Integer,ItemDescriptionDTO> itemList =
            new HashMap<Integer,ItemDescriptionDTO>();
    private final int increaseWithOne=1;
    private TotalPrice totalPriceOfOneItem;
    private int change;
    private double total;
    private int totalVAT;
    private int totalPaid;
    private List <TotalAmountObserver> paymentList= new ArrayList<>();
  
 /**
  * Create a new instance and save the time and date of current sale.
  */   
    public SaleInformation(){
        
       saleTime = LocalTime.now();
       
       saleDate = LocalDate.now();
       
    }
/**
 * save the scanned item in the sale, if the item already exist in the current 
 * sale. the quantity of the item increases, and then presents item description,
 * price, and running total.
 * @param validItem the scanned item which exists in the inventorySystem.
 */
    public void saveScannedItem(ItemDescriptionDTO validItem){
        if(alreadyScannedItem(validItem)){
           updateQuantityOfItem(validItem);
        }
        else{
            addItem(validItem);
        }
        totalPriceOfOneItem = new TotalPrice(validItem);
        total += totalPriceOfOneItem.getTotal();
        totalVAT+= validItem.getVAT();
        System.out.println(itemList.values().toString());
        System.out.println("total price incl.tax is "+total+"kr");
    }
/**
 * check if the scanned item exists in the current sale.
 * @param validItem the scanned item which exists in the inventorySystem.
 * @return true will be returned if the  current sale included the item, 
 * otherwise false.
 */
    
    private boolean alreadyScannedItem(ItemDescriptionDTO validItem){
        
            return itemList.containsKey(validItem.getIdentifier());
    }

/**
 * increase the quantity of item, and update the sale.
 * @param validItem  the scanned item which exists in the inventorySystem.
 */
    private void updateQuantityOfItem(ItemDescriptionDTO validItem){
  
        int newQuantity = validItem.getQuantityOfItem()+increaseWithOne;
        
        validItem.setQuantityOfItem(newQuantity);
  
        itemList.replace(validItem.getIdentifier(), validItem);
}
/**
 * add a item to the sale
 * @param validItem 
 */
    
    private void addItem(ItemDescriptionDTO validItem){
        itemList.put(validItem.getIdentifier(), validItem);
    }
    
/**
 * customer pay the payment and get change.
 * @param payment 
 * @return change
 */    
    public int payTotalCost(Payment payment){
  
        totalPaid = payment.getPaidAmount();
        notifyObservers();
        return change = (int) (payment.getPaidAmount() - total);
        
    }
    
    public String getLocalTime(){
        String localTime = saleDate.toString()+" " + saleTime.toString();
        return localTime;
    }
    /**
     * get the total cost of a sale
     * @return total cost of a sale
     */
    public double getTotal (){
        return this.total;
    }
    
    public double getPaidAmount(){
        return this.totalPaid;
    }
    public int getAverageVAT(){
        if(itemList.size()==0){
            return 0;
        }
        return this.totalVAT/itemList.size();
    }
    public int getchange(){
        return this.change;
    }
    public HashMap <Integer, ItemDescriptionDTO> getScannedItems(){
        return this.itemList; 
    }
    /**
     * Add observers to the array list.
     * @param observers Array List of TotalAmountOnserver 
     */
     public void addPaidAmount(List<TotalAmountObserver> observers){
        paymentList.addAll(observers);
    }
    /**
     * loops through the TotalAmoutObserver array list and prints the total amount 
     * paid for all purchases on the screen. 
     */ 
    private void notifyObservers(){
        for(TotalAmountObserver obs:paymentList){
            int amount = (int)total;
            obs.displayPaidAmount(amount);
        }
        
    }

 

    
}
    



