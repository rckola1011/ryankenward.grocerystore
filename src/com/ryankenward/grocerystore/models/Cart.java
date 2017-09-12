/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryankenward.grocerystore.models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rckola1011
 */
public class Cart {
    
    private Map<Item, Integer> items;
    
    public Cart() {
        this.items = new HashMap<>();
    }
    
    public Cart(HashMap<Item, Integer> items) {
        if (items == null)
            throw new IllegalArgumentException("Items cannot be null.");
        
        this.items = items;
    }
    
    public Map<Item, Integer> getItems() {
        return this.items;
    }
    
    public boolean addItem(Item item) {
        return addItem(item, 1);
    }
    
    public boolean addItem(Item item, int quantity) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        
        // *Required* to keep item quantity available up to date
        if (!item.subtractQuantityAvailable(quantity))
            return false;
        
        if (items.containsKey(item))
            // If item already exists, add quantity of existing item to given quantity
            quantity += items.get(item);
        // Replace existing item with given item and updated quantity, or add new item and initial quantity
        items.put(item, quantity);
        return true;
    }
    
    public boolean removeItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        if (!this.items.containsKey(item)) {
            System.out.println("The item was not found in the cart.");
            return false;
        }
        
        // Get the quantity of the item in the cart
        int quantity = items.get(item);
        // Remove item entirely from cart
        return removeItem(item, quantity);
    }
    
    public boolean removeItem(Item item, int quantity) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        
        if (!this.items.containsKey(item)) {
            System.out.println("The item was not found in the cart.");
            return false;
        }
        
        // Get the quantity of the item in the cart
        int totalQuantity = items.get(item);
        if (totalQuantity < quantity) {
            System.out.println("Quantity to remove is greater than the available quantity of the item in the cart.");
            return false;
        }
        
        // *Required* to keep item quantity available up to date
        if (!item.addQuantityAvailable(quantity))
            return false;
        
        // Remove item and quantity mapping from cart
        items.remove(item);
        return true;
    }
}
