package com.ryankenward.grocerystore.controllers;

import com.ryankenward.grocerystore.models.Store;
import com.ryankenward.grocerystore.models.io.*;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class SetupController {
    
    private StoreInput storeInput;
    private DepartmentInput departmentInput;
    
    public void setStoreInput(StoreInput storeInput) {
        this.storeInput = storeInput;
    }
    
    public void setDepartmentInput(DepartmentInput departmentInput) {
        this.departmentInput = departmentInput;
    }

    public void readStoreInput() {
        StoreInput storeInput = new StoreInput();
        storeInput.readStoreInput();
        setStoreInput(storeInput);
    }
    
    public void readDepartmentInput() {
        DepartmentInput departmentInput = new DepartmentInput();
        departmentInput.readDepartmentsByStoreInput();
        setDepartmentInput(departmentInput);
    }
    
    public void CreateStoresFromInput() {
        if (this.storeInput == null)
            readStoreInput();
        
        if (this.departmentInput == null)
            readDepartmentInput();
        
        StoreFactory storeFactory = new StoreFactory();
        Set<Store> stores = storeFactory.createStoresFromInput(storeInput, departmentInput);
    }
    
}
