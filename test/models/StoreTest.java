/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.ryankenward.grocerystore.models.*;
import com.ryankenward.grocerystore.models.enums.Departments;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author rckola1011
 */
public class StoreTest {
    
    @Test
    public void getAllItems_ShouldBeFour() {
        Item milk = new Item("Dairy-O", "Non-fat skim milk", new Price(2.99, 2.79, 2.50, false));
        Item cottageCheese = new Item("Tillamook", "2% milk fat cottage cheese", new Price(4.99, 4.50, 3.99, true));
        Department dairyDept = new Department(Departments.Dairy);
        dairyDept.setItems(new HashSet<Item>(Arrays.asList(milk, cottageCheese)));
        
        Item corn = new Item("Farmer Joe's", "White corn", new Price(0.99, 0.79, 0.49, true));
        Item lettuce = new Item("Simply Organic", "Half head of organic lettuce", new Price(3.99, 3.99, 3.99, false));
        Department produceDept = new Department(Departments.Produce);
        produceDept.setItems(new HashSet<Item>(Arrays.asList(corn, lettuce)));
        
        Set<Department> departments = new HashSet<>(Arrays.asList(dairyDept, produceDept));
        Store sut = new Store(1, "Ryan's Groceries", true, departments);
        assertEquals(sut.getAllItems().size(), 4);
    }
    
    @Test
    public void getDepartmentByName_ShouldBeProduct() {
        Item corn = new Item("Farmer Joe's", "White corn", new Price(0.99, 0.79, 0.49, true));
        Item lettuce = new Item("Simply Organic", "Half head of organic lettuce", new Price(3.99, 3.99, 3.99, false));
        Department produceDept = new Department(Departments.Produce);
        produceDept.setItems(new HashSet<Item>(Arrays.asList(corn, lettuce)));
        
        Set<Department> departments = new HashSet<>(Arrays.asList(produceDept));
        Store sut = new Store(1, "Ryan's Groceries", true, departments);
        assertEquals(sut.getDepartmentByName(Departments.Produce), produceDept);
    }
    
    @Test
    public void getDepartmentByName_ShouldBeNull() {
        Set<Department> departments = new HashSet<>();
        Store sut = new Store(1, "Ryan's Groceries", true, departments);
        assertEquals(sut.getDepartmentByName(Departments.Produce), null);
    }
}
