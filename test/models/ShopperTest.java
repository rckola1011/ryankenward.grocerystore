package models;

import com.ryankenward.grocerystore.models.*;
import com.ryankenward.grocerystore.models.enums.Departments;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rckola1011
 */
public class ShopperTest {
    
    @Test
    public void shop_ShouldBeAtStore() {
        Set<Department> departments = new HashSet<>();
        GroceryStore store = new GroceryStore(1, "Ryan's Groceries", true, departments);
        
        Shopper sut = new Shopper("Test Shoppie");
        sut.shop(store, true);
        
        Assert.assertEquals("Test Shoppie", sut.getName());
        Assert.assertEquals(store, sut.getStore());
        Assert.assertEquals(true, sut.getMember());
    }
    
    @Test
    public void getItemPrice_ShouldBeZero() {
        Set<Department> departments = new HashSet<>();
        GroceryStore store = new GroceryStore(1, "Ryan's Groceries", true, departments);
        Shopper shopper = new Shopper("Test Shoppie");
        shopper.shop(store, false);
        
        double sut = shopper.getItemPrice(new Item("Land O' Lakes", "Tub o' butter", new Price(2.99, 2.79, 2.50, false), 14));
        
        Assert.assertEquals(0, sut, 0);
    }
    
    @Test
    public void getItemPrice_ShouldBeThreeNintyNine() {
        Item corn = new Item("Farmer Joe's", "White corn", new Price(0.99, 0.79, 0.49, true), 22);
        Item lettuce = new Item("Simply Organic", "Half head of organic lettuce", new Price(3.99, 3.99, 3.99, false), 6);
        Department produceDept = new Department(Departments.Produce.toString());
        produceDept.setItems(new HashSet<Item>(Arrays.asList(corn, lettuce)));
        Set<Department> departments = new HashSet<>(Arrays.asList(produceDept));
        GroceryStore store = new GroceryStore(1, "Ryan's Groceries", true, departments);
        Shopper shopper = new Shopper("Test Shoppie");
        shopper.shop(store, false);
        shopper.getCart().addItem(corn);
        shopper.getCart().addItem(lettuce);
        
        double sut = shopper.getItemPrice(lettuce);
        
        Assert.assertEquals(3.99, sut, 0);
    }
}
