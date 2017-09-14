package models.io;

import com.ryankenward.grocerystore.models.Department;
import com.ryankenward.grocerystore.models.io.DepartmentInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rckola1011
 */
public class DepartmentInputTest {
    
    public static final String TEST_INPUT_DIRECTORY = "input" + File.separator + "test" + File.separator;
    public static final String TEST_FILE_NAME = "departmentInputTest.csv";
    
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
            
            writer.append("1,Produce,Joe’s Farm,Half head of lettuce - Organic,3.99,3.79,0,FALSE,12");
            writer.append("\n");
            writer.append("1,Produce,Maryville,Red tomato,0.79,0.69,0,TRUE,30");
            writer.append("\n");
            writer.append("2,Produce,Bob’s Farm,Yellow ear of corn,0.79,0.25,0.25,TRUE,30");
            writer.append("\n");
            writer.append("2,Deli,Boar’s Head,Honey ham - 1 lb.,7.99,5.79,5.49,TRUE,6");
            
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
    public void readDepartmentByStoreInput_ShouldBeMapOfDepartments() {
        DepartmentInput sut = new DepartmentInput();
        sut.readDepartmentsByStoreInput(TEST_INPUT_DIRECTORY + TEST_FILE_NAME);
        Map<Integer, Set<Department>> departmentMap = sut.getDepartmentsByStore();
        
        assertThat(departmentMap.isEmpty(), is(equalTo(false)));
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
