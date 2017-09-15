package com.ryankenward.grocerystore.controllers;

import com.ryankenward.grocerystore.models.*;
import com.ryankenward.grocerystore.models.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class SetupController {
    
    public void createStoresFromInput() {
        GroceryStoreInput storeInput = new GroceryStoreInput();
        List<String[]> s = storeInput.readInput();
        Set<GroceryStore> stores = storeInput.createFromInput(s);
        
        DepartmentInput departmentInput = new DepartmentInput();
        List<String[]> d = departmentInput.readInput();
        Map<Integer, Set<Department>> departments = departmentInput.createFromInput(d);
        
        GroceryStoreFactory storeFactory = new GroceryStoreFactory();
        stores = storeFactory.setDepartments(stores, departments);
        
        // TODO persist the stores
    }
    
}
