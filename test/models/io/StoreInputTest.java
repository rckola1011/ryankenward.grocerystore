package models.io;

import com.ryankenward.grocerystore.models.io.StoreInput;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rckola1011
 */
public class StoreInputTest {

    @Test
    public void readStoreInput_ShouldBeListOfStores() {
        StoreInput sut = new StoreInput();
        sut.readStoreInput();
        
        Assert.assertTrue(sut.getStores().size() > 0);
    }
    
}
