package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.Department;
import com.ryankenward.grocerystore.models.GroceryStore;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class GroceryStoreFactory {

    public Set<GroceryStore> setDepartments(Set<GroceryStore> stores, Map<Integer, Set<Department>> departmentsByStore) {
        if (stores == null)
            throw new IllegalArgumentException("Stores cannot be null.");
        
        if (departmentsByStore == null)
            throw new IllegalArgumentException("DepartmentsByStore cannot be null.");
        
        stores.forEach(s -> s.setDepartments(
                departmentsByStore.entrySet().stream()
                        .filter(e -> e.getKey() == s.getStoreNumber())
                        .findFirst()
                        .get()
                        .getValue()
        ));
        
        return stores;
    }
}
