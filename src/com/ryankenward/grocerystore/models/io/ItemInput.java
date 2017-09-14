package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.Item;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rckola1011
 */
public class ItemInput {
    
    public Set<Item> createItemsByDepartmentFromInput(List<String[]> itemsByDepartmentInput) {
        Set<Item> items = new HashSet<>();
        for (String[] departmentItemData : itemsByDepartmentInput) {
            items.add(
                    createItemFromInput(departmentItemData)
            );
        }
        return items;
    }

    public Item createItemFromInput(String[] departmentItemData) {
        try {
            return new Item(
                    departmentItemData[2],
                    departmentItemData[3],
                    new PriceInput().createPriceFromInput(departmentItemData),
                    Integer.parseInt(departmentItemData[8])
            );
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Inproper input file format.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error converting string to number.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error creating Item object.");
            e.printStackTrace();
        }
        return null;
    }
    
}
