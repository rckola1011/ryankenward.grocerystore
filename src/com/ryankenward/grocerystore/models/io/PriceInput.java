package com.ryankenward.grocerystore.models.io;

import com.ryankenward.grocerystore.models.Price;

/**
 *
 * @author rckola1011
 */
public class PriceInput {

    public Price createPriceFromInput(String[] departmentItemData) {
        try {
            return new Price(
                    Double.parseDouble(departmentItemData[4]),
                    Double.parseDouble(departmentItemData[5]),
                    Double.parseDouble(departmentItemData[6]),
                    Boolean.parseBoolean(departmentItemData[7])
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
        } catch (Exception e) {
            System.err.println("Error creating Price object.");
            e.printStackTrace();
        }
        return null;
    }
    
}
