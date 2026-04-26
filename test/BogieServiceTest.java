import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BogieServiceTest {

    private BogieService service;

    @Before
    public void setUp() {
        service = new BogieService();
    }

    private List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Luxury", 80));
        return list;
    }

    // ========== FilterByCapacity Tests (UC8) ==========

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 70);
        assertTrue("All filtered bogies should have capacity > 70",
                result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 72);
        assertTrue("Bogies with capacity equal to threshold should be excluded",
                result.stream().noneMatch(b -> b.getCapacity() == 72));
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 60);
        assertTrue("Bogies with capacity less than or equal to threshold should be excluded",
                result.stream().noneMatch(b -> b.getCapacity() <= 60));
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 50);
        assertEquals("Should have exactly 3 bogies matching the filter", 3, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 100);
        assertTrue("Result should be empty when no bogies match threshold", result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> result = service.filterByCapacity(getSampleBogies(), 10);
        assertEquals("Should return all 4 bogies when threshold is very low", 4, result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> result = service.filterByCapacity(new ArrayList<>(), 50);
        assertTrue("Result should be empty when input list is empty", result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        int originalSize = original.size();
        service.filterByCapacity(original, 60);
        assertEquals("Original list should not be modified by filter operation",
                originalSize, original.size());
    }

    // ========== GroupByType Tests (UC9) ==========

    @Test
    public void testGroupByType_CorrectGrouping() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 60));

        Map<String, List<Bogie>> grouped = service.groupByType(bogies);

        assertTrue("Should contain 'Sleeper' group", grouped.containsKey("Sleeper"));
        assertTrue("Should contain 'AC Chair' group", grouped.containsKey("AC Chair"));
        assertEquals("Sleeper group should have 2 bogies", 2, grouped.get("Sleeper").size());
        assertEquals("AC Chair group should have 1 bogie", 1, grouped.get("AC Chair").size());
    }

    @Test
    public void testGroupByType_EmptyList() {
        Map<String, List<Bogie>> grouped = service.groupByType(new ArrayList<>());
        assertTrue("Grouped result should be empty for empty input", grouped.isEmpty());
    }

    @Test
    public void testGroupByType_SingleType() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 60));

        Map<String, List<Bogie>> grouped = service.groupByType(bogies);

        assertEquals("Should have only 1 group", 1, grouped.size());
        assertEquals("Sleeper group should have 2 bogies", 2, grouped.get("Sleeper").size());
    }

    // ========== GetTotalCapacity Tests (UC10) ==========

    @Test
    public void testGetTotalCapacity_ValidBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        int totalCapacity = service.getTotalCapacity(bogies);
        assertEquals("Total capacity should be 222", 222, totalCapacity);
    }

    @Test
    public void testGetTotalCapacity_EmptyList() {
        int totalCapacity = service.getTotalCapacity(new ArrayList<>());
        assertEquals("Total capacity of empty list should be 0", 0, totalCapacity);
    }

    @Test
    public void testGetTotalCapacity_SingleBogie() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 75));

        int totalCapacity = service.getTotalCapacity(bogies);
        assertEquals("Total capacity should be 75", 75, totalCapacity);
    }

    @Test
    public void testGetTotalCapacity_LargeCapacities() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Luxury", 100));
        bogies.add(new Bogie("Luxury", 100));
        bogies.add(new Bogie("Luxury", 100));

        int totalCapacity = service.getTotalCapacity(bogies);
        assertEquals("Total capacity should be 300", 300, totalCapacity);
    }

    @Test
    public void testSort_BasicSorting() {
        int[] capacities = { 72, 56, 24, 70, 60 };
        int[] expected = { 24, 56, 60, 70, 72 };

        int[] sorted = service.sortPassengerBogieCapacities(capacities);
        assertArrayEquals("Basic bubble sort should sort capacities in ascending order", expected, sorted);
    }

    @Test
    public void testSort_PassengerCapacitiesAlreadySorted() {
        int[] capacities = { 24, 56, 60, 70, 72 };
        int[] expected = { 24, 56, 60, 70, 72 };

        int[] sorted = service.sortPassengerBogieCapacities(capacities);
        assertArrayEquals("Already sorted array should remain unchanged", expected, sorted);
    }

    @Test
    public void testSort_DuplicateValues() {
        int[] capacities = { 72, 56, 56, 24 };
        int[] expected = { 24, 56, 56, 72 };

        int[] sorted = service.sortPassengerBogieCapacities(capacities);
        assertArrayEquals("Bubble sort should handle duplicate values correctly", expected, sorted);
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] capacities = { 50 };
        int[] expected = { 50 };

        int[] sorted = service.sortPassengerBogieCapacities(capacities);
        assertArrayEquals("Single-element array should remain unchanged", expected, sorted);
    }

    @Test
    public void testSort_AllEqualValues() {
        int[] capacities = { 40, 40, 40 };
        int[] expected = { 40, 40, 40 };

        int[] sorted = service.sortPassengerBogieCapacities(capacities);
        assertArrayEquals("Array with all equal values should remain unchanged", expected, sorted);
    }

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] names = { "Sleeper", "AC Chair", "First Class", "General", "Luxury" };
        String[] expected = { "AC Chair", "First Class", "General", "Luxury", "Sleeper" };

        String[] sorted = service.sortBogieNames(names);
        assertArrayEquals("Basic alphabetical sort should order bogie names", expected, sorted);
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] names = { "Luxury", "General", "Sleeper", "AC Chair" };
        String[] expected = { "AC Chair", "General", "Luxury", "Sleeper" };

        String[] sorted = service.sortBogieNames(names);
        assertArrayEquals("Unsorted bogie names should be sorted alphabetically", expected, sorted);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] names = { "AC Chair", "First Class", "General" };
        String[] expected = { "AC Chair", "First Class", "General" };

        String[] sorted = service.sortBogieNames(names);
        assertArrayEquals("Already sorted bogie names should remain unchanged", expected, sorted);
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] names = { "Sleeper", "AC Chair", "Sleeper", "General" };
        String[] expected = { "AC Chair", "General", "Sleeper", "Sleeper" };

        String[] sorted = service.sortBogieNames(names);
        assertArrayEquals("Duplicate bogie names should be handled correctly", expected, sorted);
    }

    @Test
    public void testSort_SingleElementNameArray() {
        String[] names = { "Sleeper" };
        String[] expected = { "Sleeper" };

        String[] sorted = service.sortBogieNames(names);
        assertArrayEquals("Single-element array should remain unchanged", expected, sorted);
    }

    @Test
    public void testSearch_BogieFound() {
        String[] bogieIds = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertTrue("Search should return true when the bogie ID exists", service.searchBogieById(bogieIds, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] bogieIds = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertFalse("Search should return false when the bogie ID does not exist",
                service.searchBogieById(bogieIds, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] bogieIds = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertTrue("Search should find a match at the first array position",
                service.searchBogieById(bogieIds, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] bogieIds = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        assertTrue("Search should find a match at the last array position", service.searchBogieById(bogieIds, "BG550"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] bogieIds = { "BG101" };
        assertTrue("Search should work correctly for a single-element array",
                service.searchBogieById(bogieIds, "BG101"));
    }
}