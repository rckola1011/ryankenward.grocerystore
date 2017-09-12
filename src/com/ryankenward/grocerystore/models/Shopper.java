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
}
