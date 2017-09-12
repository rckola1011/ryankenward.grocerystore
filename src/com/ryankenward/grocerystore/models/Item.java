/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryankenward.grocerystore.models;

/**
 *
 * @author rckola1011
 */
public class Item {
    
    private String brand;
    private String description;
    private Price price;
    
    public Item(String brand, String description, Price price) {
        this.brand = brand;
        this.description = description;
        this.price = price;
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
}
