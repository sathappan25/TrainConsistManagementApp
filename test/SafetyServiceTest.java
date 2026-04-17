import java.util.ArrayList;
import java.util.List;

public class SafetyServiceTest {

    public static void main(String[] args) {
        SafetyService service = new SafetyService();

        // Test 1: All cylindrical bogies carry Petroleum (safe)
        List<GoodsBogie> list1 = new ArrayList<>();
        list1.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list1.add(new GoodsBogie("Rectangular", "Coal"));
        boolean result1 = service.isTrainSafe(list1);
        System.out.println("Test 1 - All safe: " + result1); // true

        // Test 2: Cylindrical bogie carries invalid cargo (unsafe)
        List<GoodsBogie> list2 = new ArrayList<>();
        list2.add(new GoodsBogie("Cylindrical", "Coal"));
        list2.add(new GoodsBogie("Rectangular", "Grain"));
        boolean result2 = service.isTrainSafe(list2);
        System.out.println("Test 2 - Unsafe due to Cylindrical bogie: " + result2); // false

        // Test 3: Non-cylindrical bogies are flexible
        List<GoodsBogie> list3 = new ArrayList<>();
        list3.add(new GoodsBogie("Open", "Coal"));
        list3.add(new GoodsBogie("Rectangular", "Grain"));
        boolean result3 = service.isTrainSafe(list3);
        System.out.println("Test 3 - Non-cylindrical only: " + result3); // true

        // Test 4: Mixed with one violation
        List<GoodsBogie> list4 = new ArrayList<>();
        list4.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list4.add(new GoodsBogie("Cylindrical", "Coal")); // violation
        boolean result4 = service.isTrainSafe(list4);
        System.out.println("Test 4 - Mixed with violation: " + result4); // false

        // Test 5: Empty list
        List<GoodsBogie> list5 = new ArrayList<>();
        boolean result5 = service.isTrainSafe(list5);
        System.out.println("Test 5 - Empty list: " + result5); // true
    }
}