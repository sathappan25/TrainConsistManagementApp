import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidationServiceTest {

    private ValidationService service;

    @Before
    public void setUp() {
        service = new ValidationService();
    }

    // ========== Train ID Validation Tests ==========

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue("Valid Train ID should pass validation", service.isValidTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat_TRAIN12() {
        assertFalse("Invalid Train ID format TRAIN12 should fail", service.isValidTrainId("TRAIN12"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat_TRN12A() {
        assertFalse("Invalid Train ID format TRN12A should fail", service.isValidTrainId("TRN12A"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat_1234TRN() {
        assertFalse("Invalid Train ID format 1234-TRN should fail", service.isValidTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_TrainIDTooShort() {
        assertFalse("Train ID with too few digits should fail", service.isValidTrainId("TRN-123"));
    }

    @Test
    public void testRegex_TrainIDTooLong() {
        assertFalse("Train ID with too many digits should fail", service.isValidTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_TrainIDEmptyInput() {
        assertFalse("Empty Train ID should fail validation", service.isValidTrainId(""));
    }

    @Test
    public void testRegex_TrainIDExtraCharacters() {
        assertFalse("Train ID with extra characters should fail", service.isValidTrainId("TRN-1234X"));
    }

    // ========== Cargo Code Validation Tests ==========

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue("Valid Cargo Code should pass validation", service.isValidCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCode_Lowercase() {
        assertFalse("Cargo Code with lowercase should fail", service.isValidCargoCode("PET-ab"));
    }

    @Test
    public void testRegex_InvalidCargoCode_NoDash() {
        assertFalse("Cargo Code without dash should fail", service.isValidCargoCode("PET123"));
    }

    @Test
    public void testRegex_InvalidCargoCode_WrongOrder() {
        assertFalse("Cargo Code with wrong order should fail", service.isValidCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_CargoCode_MixedCase() {
        assertFalse("Cargo Code with mixed case should fail", service.isValidCargoCode("PET-Ab"));
    }

    @Test
    public void testRegex_CargoCodeEmptyInput() {
        assertFalse("Empty Cargo Code should fail validation", service.isValidCargoCode(""));
    }

    @Test
    public void testRegex_CargoCode_ExtraLetters() {
        assertFalse("Cargo Code with extra letters should fail", service.isValidCargoCode("PET-ABC"));
    }

    // ========== Boundary and Edge Cases ==========

    @Test
    public void testRegex_TrainID_AllDigits() {
        assertTrue("Train ID with all valid digits should pass", service.isValidTrainId("TRN-0000"));
    }

    @Test
    public void testRegex_CargoCode_VariousValidCodes() {
        assertTrue("Valid cargo code PET-AB should pass", service.isValidCargoCode("PET-AB"));
        assertTrue("Valid cargo code PET-XY should pass", service.isValidCargoCode("PET-XY"));
    }

    @Test
    public void testRegex_Null_TrainID() {
        assertFalse("Null Train ID should fail validation", service.isValidTrainId(null));
    }

    @Test
    public void testRegex_Null_CargoCode() {
        assertFalse("Null Cargo Code should fail validation", service.isValidCargoCode(null));
    }
}