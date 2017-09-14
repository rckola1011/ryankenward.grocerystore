package controllers;

import com.ryankenward.grocerystore.controllers.SetupController;
import org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author rckola1011
 */
public class SetupControllerTest {
    
    @Test
    public void createStoresFromInput_ShouldBeStores() {
        SetupController sut = new SetupController();
        sut.CreateStoresFromInput();
    }

}
