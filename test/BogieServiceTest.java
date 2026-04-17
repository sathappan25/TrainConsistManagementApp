import java.util.List;
import java.util.ArrayList;

public class BogieServiceTest {

    private static BogieService service = new BogieService();

    public static void main(String[] args) {

        System.out.println("Running Test Cases...\n");

        testFilter_CapacityGreaterThanThreshold();
        testFilter_CapacityEqualToThreshold();
        testFilter_CapacityLessThanThreshold();
        testFilter_MultipleBogiesMatching();
        testFilter_NoBogiesMatching();
        testFilter_AllBogiesMatching();
        testFilter_EmptyBogieList();
        testFilter_OriginalListUnchanged();

        System.out.println("\nAll Tests Executed.");
    }

    private static List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Luxury", 80));
        return list;
    }

    // ✅ Simple assertion helpers
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

    // ✅ Test Cases

    static void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 70);
        boolean condition = result.stream().allMatch(b -> b.getCapacity() > 70);
        assertTrue(condition, "Capacity > Threshold");
    }

    static void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 72);
        boolean condition = result.stream().noneMatch(b -> b.getCapacity() == 72);
        assertTrue(condition, "Capacity == Threshold excluded");
    }

    static void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 60);
        boolean condition = result.stream().noneMatch(b -> b.getCapacity() <= 60);
        assertTrue(condition, "Capacity < Threshold excluded");
    }

    static void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 50);
        assertEquals(2, result.size(), "Multiple bogies matching");
    }

    static void testFilter_NoBogiesMatching() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 100);
        assertTrue(result.isEmpty(), "No bogies matching");
    }

    static void testFilter_AllBogiesMatching() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 10);
        assertEquals(4, result.size(), "All bogies matching");
    }

    static void testFilter_EmptyBogieList() {
        List<Bogie> result = service.filterByCapacity(new ArrayList<>(), 50);
        assertTrue(result.isEmpty(), "Empty bogie list");
    }

    static void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        service.filterByCapacity(original, 60);
        assertEquals(4, original.size(), "Original list unchanged");
    }
}