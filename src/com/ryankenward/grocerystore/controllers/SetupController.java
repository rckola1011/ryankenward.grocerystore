package com.ryankenward.grocerystore.controllers;

import com.ryankenward.grocerystore.models.io.*;

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

    public void readStoreInput() {
        StoreInput storeInput = new StoreInput();
        storeInput.readStoreInput();
        setStoreInput(storeInput);
    }
    
    public void readItemInput() {
        
    }
    
}
