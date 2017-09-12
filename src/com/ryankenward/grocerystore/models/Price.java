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
public class Price {

    private double originalPrice;
    private double salePrice;
    private double memberPrice;
    private boolean onSale;
    
    public Price(double originalPrice, double salePrice, double memberPrice, boolean onSale) {
        if (salePrice > originalPrice)
            throw new IllegalArgumentException("Sale price must be lower than original price.");
        
        if (memberPrice > originalPrice)
            throw new IllegalArgumentException("Member price must be lower than original price.");
        
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.memberPrice = memberPrice;
        this.onSale = onSale;
    }
    
    /**
     * @return the originalPrice
     */
    public double getOriginalPrice() {
        return this.originalPrice;
    }

    /**
     * @return the salePrice
     */
    public double getSalePrice() {
        return this.salePrice;
    }

    /**
     * @return the memberPrice
     */
    public double getMemberPrice() {
        return this.memberPrice;
    }
    
    public boolean getOnSale() {
        return this.onSale;
    }
    
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
}
