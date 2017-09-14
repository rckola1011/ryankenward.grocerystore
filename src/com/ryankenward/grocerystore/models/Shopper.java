package com.ryankenward.grocerystore.models;

import java.util.Map;

/**
 *
 * @author rckola1011
 */
public class Shopper {
    
    private String name;
    private Store store;
    private boolean member;
    private Cart cart;
    
    public Shopper(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Store getStore() {
        return this.store;
    }
    
    public boolean getMember() {
        return this.member;
    }
    
    public Cart getCart() {
        return this.cart;
    }
    
    public void shop(Store store, boolean member) {
        this.store = store;
        this.member = member;
        this.cart = new Cart();
    }
    
    public double getItemPrice(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        if (!this.cart.getItems().containsKey(item)) {
            System.out.println("The item was not found in the cart.");
            return 0;
        }
        
        int quantity = this.cart.getItems().get(item);
        return getItemPrice(item, quantity);
    }
    
    public double getItemPrice(Item item, int quantity) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        
        double totalItemPrice;
        Price itemPrice = item.getPrice();
        if (this.member) {   // Shopper is a member
            if (itemPrice.getOnSale() 
                    && (itemPrice.getSalePrice() < itemPrice.getMemberPrice()))
                // Use sale price if item is on sale and sale price is lower than member price
                totalItemPrice = itemPrice.getSalePrice();
            else
                // Use member price if item is not on sale or member price is lower than sales price
                totalItemPrice = itemPrice.getMemberPrice();
        } else if (itemPrice.getOnSale()) {
            // Use sale price if item is on sale and shopper is not a member
            totalItemPrice = itemPrice.getSalePrice();
        } else {
            // Use original price if shopper is not a member and the item is not on sale
            totalItemPrice = itemPrice.getOriginalPrice();
        }
        totalItemPrice *= quantity; // Multiply price by quantity
        return totalItemPrice;
    }
    
    public double getCartTotalPrice() {
        if (this.cart.getItems() == null)
            return 0;
        
        double total = 0;
        for (Map.Entry<Item, Integer> entry : this.cart.getItems().entrySet()) {
            total += getItemPrice(entry.getKey(), entry.getValue());
        }
        return total;
    }
}
