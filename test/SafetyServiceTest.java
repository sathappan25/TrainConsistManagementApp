import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class SafetyServiceTest {

    private SafetyService service;

    @Before
    public void setUp() {
        service = new SafetyService();
    }

    // ========== Safety Validation Tests (UC12) ==========

    @Test
    public void testSafety_AllValidBogies() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        
        assertTrue("Train with all valid bogies should be safe", service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal")); // violation: Cylindrical can only carry Petroleum
        bogies.add(new GoodsBogie("Rectangular", "Grain"));
        
        assertFalse("Train with cylindrical bogie carrying invalid cargo should be unsafe", 
            service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesOnly() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Open", "Grain"));
        
        assertTrue("Train with only non-cylindrical bogies should be safe", service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_MixedWithViolation() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal")); // violation
        
        assertFalse("Train with at least one safety violation should be unsafe", 
            service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        
        assertTrue("Empty train should be considered safe", service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_SingleCylindricalWithPetroleum() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        
        assertTrue("Single cylindrical bogie with petroleum should be safe", service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_MultipleCylindricalAllPetroleum() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        
        assertTrue("Multiple cylindrical bogies all carrying petroleum should be safe", 
            service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_SingleCylindricalWithCoal() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));
        
        assertFalse("Cylindrical bogie carrying coal should be unsafe", service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_RectangularBogieAnyCargoType() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Rectangular", "Grain"));
        bogies.add(new GoodsBogie("Rectangular", "Petroleum"));
        
        assertTrue("Rectangular bogies can carry any cargo type safely", service.isTrainSafe(bogies));
    }

    @Test
    public void testSafety_OpenBogieAnyCargoType() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Open", "Grain"));
        
        assertTrue("Open bogies can carry any cargo type safely", service.isTrainSafe(bogies));
    }
}