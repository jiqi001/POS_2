/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.integration;

/**
 *
 * Contains information about one particular item, the quantity of
 * a item is set to be 1.
 */
public class ItemDescriptionDTO {
    private int identifier;
    private double price;
    private int VAT;
    private String nameOfItem;
    private int quantityOfItem;
    private final int one=1;
    /**
     * Creates a new instance representing a particular item.
     * @param identifier The bar-code of a particular item.
     * @param price price of a particular item
     * @param VAT tax of a particular item
     * @param nameOfItem name of a particular item
     * @param quantityOfItem quantity of a particular item is set to be 1 when
     * the cashier does not enter the quantity of the item.
     */
    
    public ItemDescriptionDTO(int identifier, double price, int VAT, String nameOfItem, int quantityOfItem){
        this.nameOfItem = nameOfItem;
        this.identifier = identifier;
        this.VAT = VAT;
        this.quantityOfItem=quantityOfItem;
        this.price = price;
    }
    
    public ItemDescriptionDTO(int identifier){
        this.quantityOfItem=one;
        this.identifier=identifier;
    }
/**
 * Set the quantity of the scanned item if there are more than 1 item with the same
 * identifier.
 * @param quantity quantity of the scanned item.
 */
    public void setQuantityOfItem(int quantity){
        this.quantityOfItem = quantity;
    }
 
    public int getQuantityOfItem(){
        return this.quantityOfItem;
    }
    
    public int getIdentifier(){
        return this.identifier;
    }
    
    public double getPrice(){
        return this.price;
    }
    public int getVAT(){
        return this.VAT;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.nameOfItem);
        sb.append(" ");
        sb.append(this.quantityOfItem);
        sb.append("st");
        sb.append(" ");
        sb.append(this.price);
        sb.append("kr");
        sb.append(" ");
        sb.append(this.VAT);
        sb.append("%");
        return sb.toString();
    }
}

    

    
   
 
   