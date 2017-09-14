package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.Store;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class StoreInput {
    
    private static final String STORE_INPUT_FILE_PATH = "input" + File.separator + "stores.csv";
    private Set<Store> stores;
    
    public Set<Store> getStores() {
        return this.stores;
    }
    
    private void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public void readStoreInput() {
        InputReader inputReader = new InputReader();
        List<String[]> storeInput = inputReader.readCsv(STORE_INPUT_FILE_PATH);
        setStores(createStoresFromInput(storeInput));
    }
    
    public Set<Store> createStoresFromInput(List<String[]> storeInput) {
        Set<Store> createdStores = new HashSet<>();
        for (String[] storeData : storeInput) {
            try {
                createdStores.add(new Store(
                        Integer.parseInt(storeData[0]), 
                        storeData[1], 
                        Boolean.parseBoolean(storeData[2]), 
                        new HashSet<>()
                ));
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Inproper input file format.");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("Error converting string to number.");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error creating Store object.");
                e.printStackTrace();
            }
        }
        return createdStores;
    }

}
