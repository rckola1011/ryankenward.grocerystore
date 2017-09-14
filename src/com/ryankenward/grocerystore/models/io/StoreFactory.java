package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.Store;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class StoreFactory {

    public Set<Store> createStoresFromInput(StoreInput storeInput, DepartmentInput departmentInput) {
        if (storeInput == null)
            throw new IllegalArgumentException("StoreInput cannot be null.");
        
        if (departmentInput == null)
            throw new IllegalArgumentException("DepartmentInput cannot be null.");
        
        if (storeInput.getStores() == null)
            throw new NullPointerException("StoreInput does not contain any store data.");
        
        if (departmentInput.getDepartmentsByStore() == null)
            throw new NullPointerException("DepartmentInput does not contain any department data.");
        
        storeInput.getStores().forEach(s -> s.setDepartments(
                departmentInput.getDepartmentsByStore().entrySet().stream().filter(e -> e.getKey() == s.getStoreNumber()).findFirst().get().getValue()
        ));
        
        return storeInput.getStores();
    }
}
