public class ValidationServiceTest {

    private static ValidationService service = new ValidationService();

    public static void main(String[] args) {

        System.out.println("Running UC11 Test Cases...\n");

        testRegex_ValidTrainID();
        testRegex_InvalidTrainIDFormat();
        testRegex_ValidCargoCode();
        testRegex_InvalidCargoCodeFormat();
        testRegex_TrainIDDigitLengthValidation();
        testRegex_CargoCodeUppercaseValidation();
        testRegex_EmptyInputHandling();
        testRegex_ExactPatternMatch();

        System.out.println("\nAll UC11 Tests Executed.");
    }

    // Assertion helper
    private static void assertTrue(boolean condition, String testName) {
        if (condition) {
            System.out.println("✔ PASS: " + testName);
        } else {
            System.out.println("✘ FAIL: " + testName);
        }
    }

    private static void assertFalse(boolean condition, String testName) {
        assertTrue(!condition, testName);
    }

    static void testRegex_ValidTrainID() {
        assertTrue(service.isValidTrainId("TRN-1234"), "Valid Train ID");
    }

    static void testRegex_InvalidTrainIDFormat() {
        assertFalse(service.isValidTrainId("TRAIN12"), "Invalid Train ID - TRAIN12");
        assertFalse(service.isValidTrainId("TRN12A"), "Invalid Train ID - TRN12A");
        assertFalse(service.isValidTrainId("1234-TRN"), "Invalid Train ID - 1234-TRN");
    }

    static void testRegex_ValidCargoCode() {
        assertTrue(service.isValidCargoCode("PET-AB"), "Valid Cargo Code");
    }

    static void testRegex_InvalidCargoCodeFormat() {
        assertFalse(service.isValidCargoCode("PET-ab"), "Invalid Cargo Code - lowercase");
        assertFalse(service.isValidCargoCode("PET123"), "Invalid Cargo Code - no dash");
        assertFalse(service.isValidCargoCode("AB-PET"), "Invalid Cargo Code - wrong order");
    }

    static void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(service.isValidTrainId("TRN-123"), "Train ID too short");
        assertFalse(service.isValidTrainId("TRN-12345"), "Train ID too long");
    }

    static void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(service.isValidCargoCode("PET-Ab"), "Mixed case invalid");
    }

    static void testRegex_EmptyInputHandling() {
        assertFalse(service.isValidTrainId(""), "Empty Train ID");
        assertFalse(service.isValidCargoCode(""), "Empty Cargo Code");
    }

    static void testRegex_ExactPatternMatch() {
        assertFalse(service.isValidTrainId("TRN-1234X"), "Extra characters invalid");
        assertFalse(service.isValidCargoCode("PET-ABC"), "Extra letters invalid");
    }
}