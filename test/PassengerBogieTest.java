import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerBogieTest {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull("Bogie should be created successfully", bogie);
        assertEquals("Bogie type should be Sleeper", "Sleeper", bogie.getType());
        assertEquals("Bogie capacity should be 72", 72, bogie.getCapacity());
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("AC Chair", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("First Class", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("Sleeper", -5);
            fail("Should have thrown InvalidCapacityException");
        } catch (InvalidCapacityException e) {
            assertEquals("Exception message should match", 
                "Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC Chair", 50);
        assertEquals("Type should be AC Chair", "AC Chair", bogie.getType());
        assertEquals("Capacity should be 50", 50, bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 60));
        bogies.add(new PassengerBogie("AC Chair", 50));
        bogies.add(new PassengerBogie("First Class", 30));
        
        assertEquals("Should have 3 bogies", 3, bogies.size());
        assertTrue("All bogies should be created successfully", 
            bogies.stream().allMatch(b -> b.getCapacity() > 0));
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_LargeNegativeCapacity() throws InvalidCapacityException {
        new PassengerBogie("Luxury", -100);
    }

    @Test
    public void testException_BoundaryValueCityEqualToOne() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 1);
        assertEquals("Capacity should be 1 (boundary value)", 1, bogie.getCapacity());
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_BoundaryValueZero() throws InvalidCapacityException {
        new PassengerBogie("Sleeper", 0);
    }
}import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerBogieTest {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        assertNotNull("Bogie should be created successfully", bogie);
        assertEquals("Bogie type should be Sleeper", "Sleeper", bogie.getType());
        assertEquals("Bogie capacity should be 72", 72, bogie.getCapacity());
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("AC Chair", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("First Class", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("Sleeper", -5);
            fail("Should have thrown InvalidCapacityException");
        } catch (InvalidCapacityException e) {
            assertEquals("Exception message should match", 
                "Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC Chair", 50);
        assertEquals("Type should be AC Chair", "AC Chair", bogie.getType());
        assertEquals("Capacity should be 50", 50, bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 60));
        bogies.add(new PassengerBogie("AC Chair", 50));
        bogies.add(new PassengerBogie("First Class", 30));
        
        assertEquals("Should have 3 bogies", 3, bogies.size());
        assertTrue("All bogies should be created successfully", 
            bogies.stream().allMatch(b -> b.getCapacity() > 0));
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_LargeNegativeCapacity() throws InvalidCapacityException {
        new PassengerBogie("Luxury", -100);
    }

    @Test
    public void testException_BoundaryValueCityEqualToOne() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 1);
        assertEquals("Capacity should be 1 (boundary value)", 1, bogie.getCapacity());
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_BoundaryValueZero() throws InvalidCapacityException {
        new PassengerBogie("Sleeper", 0);
    }
}