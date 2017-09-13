/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryankenward.grocerystore.models;

import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author rckola1011
 */
public class Store {
    
    private int storeNumber;
    private String name;
    private boolean memberClub;
    private Set<Department> departments;
    
    public Store(int storeNumber, String name, boolean memberClub, Set<Department> departments) {
        this.storeNumber = storeNumber;
        this.name = name;
        this.memberClub = memberClub;
        this.departments = departments;
    }
    
    public int getStoreNumber() {
        return this.storeNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean getMemberClub() {
        return this.memberClub;
    }
    
    public Set<Department> getDepartments() {
        return this.departments;
    }
    
    public Department getDepartmentByName(String name) {
        Department department = this.departments.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
        return department;
    }
    
    public Set<Item> getAllItems() {
        Set<Item> items = this.departments.stream().flatMap(i -> i.getItems().stream()).collect(Collectors.toSet());
        return items;
    }
    
    public boolean hasDepartment(String name) {
        return getDepartmentByName(name) != null;
    }
    
    public boolean hasItem(Item item) {
        return getAllItems().contains(item);
    }
}
