package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.GroceryStore;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class GroceryStoreInput {
    
    private static final String INPUT_FILE_PATH = "input" + File.separator + "stores.csv";

    public List<String[]> readInput() {
        return readInput(INPUT_FILE_PATH);
    }
    
    public List<String[]> readInput(String filePath) {
        return new InputReader().readCsv(filePath);
    }
    
    public Set<GroceryStore> createFromInput(List<String[]> storeInput) {
        Set<GroceryStore> createdStores = new HashSet<>();
        GroceryStore store;
        for (String[] storeData : storeInput) {
            store = createFromInput(storeData);
            if (store != null)
                createdStores.add(store);
        }
        return createdStores;
    }
    
    public GroceryStore createFromInput(String[] storeData) {
        try {
            return new GroceryStore(
                    Integer.parseInt(storeData[0]), 
                    storeData[1], 
                    Boolean.parseBoolean(storeData[2]), 
                    new HashSet<>()
            );
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Improper input file format.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error converting string to number.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error creating Store object.");
            e.printStackTrace();
        }
        return null;
    }

}
