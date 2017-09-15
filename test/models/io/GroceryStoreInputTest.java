package models.io;

import com.ryankenward.grocerystore.models.io.GroceryStoreInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rckola1011
 */
public class GroceryStoreInputTest {
    
    public static final String TEST_INPUT_DIRECTORY = "input" + File.separator + "test" + File.separator;
    public static final String TEST_FILE_NAME = "storeInputTest.csv";
    
    @Before
    public void setUp() {
        FileWriter writer = null;
        try {
            File inputDirectory = new File(TEST_INPUT_DIRECTORY);
            if (!inputDirectory.exists() 
                    && !inputDirectory.mkdirs()) {
                System.err.println("Could not create missing parent directory.");
            }
            if (!inputDirectory.canWrite()) {
                System.err.println("Can not write file to directory.  Check permissions.");
            }
            writer = new FileWriter(TEST_INPUT_DIRECTORY + TEST_FILE_NAME);
            
            writer.append("1,Ryan’s Grocery Co-op,FALSE");
            writer.append("\n");
            writer.append("2,Food Lion,TRUE");
            writer.append("\n");
            writer.append("3,Green Zebra,TRUE");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readInput_ShouldBeListOfSringArrays() {
        GroceryStoreInput sut = new GroceryStoreInput();
        List<String[]> input = sut.readInput();
        
        assertThat(input.isEmpty(), is(equalTo(false)));
        assertThat(input.size(), is(equalTo(3)));
        for (String[] s : input) {
            assertThat(s.length, is(equalTo(3)));
            assertThat(Integer.parseInt(s[0]), instanceOf(Integer.class));
        }
    }
    
    @After
    public void tearDown() {
        File testFile = new File(TEST_INPUT_DIRECTORY + TEST_FILE_NAME);
        if (testFile.exists())
            if (!testFile.delete())
                System.err.println("Unable to delete test file.  Check permissions.");
        else
            System.err.println("Unable to find test file.  File not deleted.  Check permissions.");
    }
    
}
