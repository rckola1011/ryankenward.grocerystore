package com.ryankenward.grocerystore.models;

/**
 *
 * @author rckola1011
 */
public class Item {
    
    private String brand;
    private String description;
    private Price price;
    private int quantityAvailable;
    
    public Item(String brand, String description, Price price, int quantityAvailable) {
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }
    
    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return the price
     */
    public Price getPrice() {
        return this.price;
    }
    
    /**
     * @return the quantity available
     */
    public int getQuantityAvailable() {
        return this.quantityAvailable;
    }
    
    public boolean addQuantityAvailable(int additionalQuantityAvailable) {
        if (additionalQuantityAvailable < 0)
            throw new IllegalArgumentException("Additional quantity available must be greater than zero.");
        
        this.quantityAvailable += additionalQuantityAvailable;
        return true;
    }
    
    public boolean subtractQuantityAvailable(int lessQuantityAvailable) {
        if (lessQuantityAvailable < 0)
            throw new IllegalArgumentException("Less quantity available must be greater than zero.");
        
        if (lessQuantityAvailable > this.quantityAvailable) {
            System.out.println(
                    String.format("Cannot update item quantity available ({0}) to an amount less than zero.", this.quantityAvailable)
            );
            return false;
        }
        
        this.quantityAvailable -= lessQuantityAvailable;
        return true;
    }
}
