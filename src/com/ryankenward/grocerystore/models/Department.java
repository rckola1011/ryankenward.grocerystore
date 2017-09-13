/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryankenward.grocerystore.models;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class Department {
    
    private String name;
    private Set<Item> items;
    
    public Department(String department) {
        this.name = department;
        this.items = new HashSet<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public Set<Item> getItems() {
        return this.items;
    }
    
    public void setItems(Set<Item> items) {
        if (items == null)
            throw new IllegalArgumentException("Items cannot be null.");
        
        this.items = items;
    }
    
    public void addItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        
        this.items.add(item);
    }
    
    
    
}
