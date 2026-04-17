import java.util.List;
import java.util.ArrayList;

public class BogieServiceTest {

    private static BogieService service = new BogieService();

    public static void main(String[] args) {

        System.out.println("Running UC10 Test Cases...\n");

        testReduce_TotalSeatCalculation();
        testReduce_MultipleBogiesAggregation();
        testReduce_SingleBogieCapacity();
        testReduce_EmptyBogieList();
        testReduce_CorrectCapacityExtraction();
        testReduce_AllBogiesIncluded();
        testReduce_OriginalListUnchanged();

        System.out.println("\nAll UC10 Tests Executed.");
    }

    private static List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("Sleeper", 70));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    // Assertion helpers
    private static void assertTrue(boolean condition, String testName) {
        if (condition) {
            System.out.println("✔ PASS: " + testName);
        } else {
            System.out.println("✘ FAIL: " + testName);
        }
    }

    private static void assertEquals(int expected, int actual, String testName) {
        if (expected == actual) {
            System.out.println("✔ PASS: " + testName);
        } else {
            System.out.println("✘ FAIL: " + testName +
                    " | Expected: " + expected + " but got: " + actual);
        }
    }


    static void testReduce_TotalSeatCalculation() {
        int total = service.getTotalCapacity(getSampleBogies());
        assertEquals(222, total, "Total seat calculation"); // 72+56+70+24
    }

    static void testReduce_MultipleBogiesAggregation() {
        int total = service.getTotalCapacity(getSampleBogies());
        assertTrue(total > 0, "Multiple bogies aggregation");
    }

    static void testReduce_SingleBogieCapacity() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        int total = service.getTotalCapacity(list);
        assertEquals(72, total, "Single bogie capacity");
    }

    static void testReduce_EmptyBogieList() {
        int total = service.getTotalCapacity(new ArrayList<>());
        assertEquals(0, total, "Empty bogie list");
    }

    static void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = getSampleBogies();
        int expected = 72 + 56 + 70 + 24;

        int actual = service.getTotalCapacity(list);
        assertEquals(expected, actual, "Correct capacity extraction");
    }

    static void testReduce_AllBogiesIncluded() {
        List<Bogie> list = getSampleBogies();
        int total = service.getTotalCapacity(list);

        assertTrue(total == 222, "All bogies included");
    }

    static void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        service.getTotalCapacity(original);

        assertEquals(4, original.size(), "Original list unchanged");
    }
}