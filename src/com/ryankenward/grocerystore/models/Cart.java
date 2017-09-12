/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryankenward.grocerystore.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author rckola1011
 */
public class Cart {
    
    private Map<Item, Integer> items;
    
    public Cart() {
    }
    
    public Cart(HashMap<Item, Integer> items) {
        if (items == null)
            throw new IllegalArgumentException("Items cannot be null.");
        
        this.items = items;
    }
    
    public void addItem(Item item, int quantity) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        
        if (items.containsKey(item))
            // If item already exists, add quantity of existing item to given quantity
            quantity += items.get(item);
        // Replace existing item with given item and updated quantity, or add new item and initial quantity
        items.put(item, quantity);
    }
    
    public double getTotal(Shopper shopper) {
        if (shopper == null)
            throw new IllegalArgumentException("Shopper cannot be null.");
        
        if (this.items == null)
            return 0;
        
        double total = 0;
        for (Entry<Item, Integer> entry : this.items.entrySet()) {
            Price itemPrice = entry.getKey().getPrice();
            if (shopper.getMember()) {   // Shopper is a member
                if (itemPrice.getOnSale() 
                        && (itemPrice.getSalePrice() < itemPrice.getMemberPrice()))
                    // Use sale price if item is on sale and sale price is lower than member price
                    total += itemPrice.getSalePrice();
                else
                    // Use member price if item is not on sale or member price is lower than sales price
                    total += itemPrice.getMemberPrice();
            } else if (itemPrice.getOnSale()) {
                // Use sale price if item is on sale and shopper is not a member
                total += itemPrice.getSalePrice();
            } else {
                // Use original price if shopper is not a member and the item is not on sale
                total += itemPrice.getOriginalPrice();
            }
        }
        return total;
    }
}
