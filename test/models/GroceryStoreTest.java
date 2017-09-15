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
public class GroceryStoreTest {
    
    @Test
    public void getAllItems_ShouldBeFour() {
        Item milk = new Item("Dairy-O", "Non-fat skim milk", new Price(2.99, 2.79, 2.50, false), 10);
        Item cottageCheese = new Item("Tillamook", "2% milk fat cottage cheese", new Price(4.99, 4.50, 3.99, true), 14);
        Department dairyDept = new Department(Departments.Dairy.toString());
        dairyDept.setItems(new HashSet<Item>(Arrays.asList(milk, cottageCheese)));
        
        Item corn = new Item("Farmer Joe's", "White corn", new Price(0.99, 0.79, 0.49, true), 22);
        Item lettuce = new Item("Simply Organic", "Half head of organic lettuce", new Price(3.99, 3.99, 3.99, false), 6);
        Department produceDept = new Department(Departments.Produce.toString());
        produceDept.setItems(new HashSet<Item>(Arrays.asList(corn, lettuce)));
        
        Set<Department> departments = new HashSet<>(Arrays.asList(dairyDept, produceDept));
        GroceryStore sut = new GroceryStore(1, "Ryan's Groceries", true, departments);
        Assert.assertEquals(4, sut.getAllItems().size());
    }
    
    @Test
    public void getDepartmentByName_ShouldBeProduct() {
        Item corn = new Item("Farmer Joe's", "White corn", new Price(0.99, 0.79, 0.49, true), 22);
        Item lettuce = new Item("Simply Organic", "Half head of organic lettuce", new Price(3.99, 3.99, 3.99, false), 6);
        Department produceDept = new Department(Departments.Produce.toString());
        produceDept.setItems(new HashSet<Item>(Arrays.asList(corn, lettuce)));
        
        Set<Department> departments = new HashSet<>(Arrays.asList(produceDept));
        GroceryStore sut = new GroceryStore(1, "Ryan's Groceries", true, departments);
        Assert.assertEquals(produceDept, sut.getDepartmentByName(Departments.Produce.toString()));
    }
    
    @Test
    public void getDepartmentByName_ShouldBeNull() {
        Set<Department> departments = new HashSet<>();
        GroceryStore sut = new GroceryStore(1, "Ryan's Groceries", true, departments);
        Assert.assertEquals(null, sut.getDepartmentByName(Departments.Produce.toString()));
    }
}
