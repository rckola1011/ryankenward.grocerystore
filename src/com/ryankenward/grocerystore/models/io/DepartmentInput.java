package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.*;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author rckola1011
 */
public class DepartmentInput {
    
    private static final String DEPARTMENT_INPUT_FILE_PATH = "input" + File.separator + "items.csv";
    private Map<Integer, Set<Department>> departmentsByStore;
    
    public Map<Integer, Set<Department>> getDepartmentsByStore() {
        return this.departmentsByStore;
    }
    
    private void setDepartmentsByStore(Map<Integer, Set<Department>> departmentsByStore) {
        this.departmentsByStore = departmentsByStore;
    }

    public void readDepartmentsByStoreInput() {
        readDepartmentsByStoreInput(DEPARTMENT_INPUT_FILE_PATH);
    }
    
    public void readDepartmentsByStoreInput(String filePath) {
        InputReader inputReader = new InputReader();
        List<String[]> departmentInput = inputReader.readCsv(filePath);
        
        Map<Integer, List<String[]>> departmentsByStoreInput = departmentInput.stream().collect(
                Collectors.groupingBy(s -> Integer.parseInt(s[0])));

        setDepartmentsByStore(createDepartmentsByStoreFromInput(departmentsByStoreInput));
    }
    
    public Map<Integer, Set<Department>> createDepartmentsByStoreFromInput(Map<Integer, List<String[]>> departmentsByStoreInput) {
        Map<Integer, Set<Department>> createdDepartmentsByStore = new HashMap<>();
        departmentsByStoreInput.forEach((k,v) -> createdDepartmentsByStore.put(k, 
                createDepartmentsFromItemsByDepartmentName(
                        createDepartmentsByNameFromInput(v)
                )
        ));
        return createdDepartmentsByStore;
    }
    
    public Map<String, Set<Item>> createDepartmentsByNameFromInput(List<String[]> departmentsInput) {
        Map<String, List<String[]>> itemsByDepartmentNameInput = departmentsInput.stream().collect(
                Collectors.groupingBy(s -> s[1]));
        return createItemsByDepartmentNameFromInput(itemsByDepartmentNameInput);
    }
    
    public Map<String, Set<Item>> createItemsByDepartmentNameFromInput(Map<String, List<String[]>> itemsByDepartmentNameInput) {
        ItemInput itemInput = new ItemInput();
        Map<String, Set<Item>> createdItemsByDepartmentName = new HashMap<>();
        itemsByDepartmentNameInput.forEach((k,v) -> createdItemsByDepartmentName.put(k, itemInput.createItemsByDepartmentFromInput(v)));
        return createdItemsByDepartmentName;
    }
    
    public Set<Department> createDepartmentsFromItemsByDepartmentName(Map<String, Set<Item>> createdItemsByDepartmentName) {
        Set<Department> departments = new HashSet<>();
        createdItemsByDepartmentName.forEach((k,v) -> departments.add(new Department(k,(HashSet)v)));
        return departments;
    }
    
}
