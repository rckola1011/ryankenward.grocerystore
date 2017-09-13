package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.*;
import java.io.File;
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
    
    private void setDepartments(Map<Integer, Set<Department>> departmentsByStore) {
        this.departmentsByStore = departmentsByStore;
    }

    public void readDepartmentInput() {
        InputReader inputReader = new InputReader();
        List<String[]> departmentInput = inputReader.readCsv(DEPARTMENT_INPUT_FILE_PATH);

        Map<Integer, List<String[]>> test2 = departmentInput.stream().collect(
                Collectors.groupingBy(s -> Integer.parseInt(s[0])));
        
        createDepartmentsFromInput(test2.get(1));
    }
    
    private Set<Department> createDepartmentsFromInput(List<String[]> departmentInput) {
        Set<Department> createdDepartments = new HashSet<>();
        for (String[] departmentData : departmentInput) {
            try {
                createdDepartments.add(new Department(
                        departmentData[1]
                ));
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Inproper input file format.");
                e.printStackTrace();
            }
        }
        return createdDepartments;
    }
    
    private Item createItemFromInput(String[] departmentData) {
        try {
            return new Item(
                    departmentData[2],
                    departmentData[3],
                    createPriceFromInput(departmentData),
                    Integer.parseInt(departmentData[8])
            );
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Inproper input file format.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error converting string to number.");
            e.printStackTrace();
        }
        return null;
    }
    
    private Price createPriceFromInput(String[] departmentData) {
        try {
            return new Price(
                    Double.parseDouble(departmentData[4]),
                    Double.parseDouble(departmentData[5]),
                    Double.parseDouble(departmentData[6]),
                    Boolean.parseBoolean(departmentData[7])
            );
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Inproper input file format.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error converting string to number.");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Error parsing null string.");
            e.printStackTrace();
        }
        return null;
    }

}
