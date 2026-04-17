import java.util.ArrayList;
import java.util.List;

public class PassengerBogieTest {

    public static void main(String[] args) {
        int passed = 0, failed = 0;

        // --- Test 1: Valid capacity ---
        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Test 1 Passed: " + bogie1);
            passed++;
        } catch (InvalidCapacityException e) {
            System.out.println("Test 1 Failed: " + e.getMessage());
            failed++;
        }

        // --- Test 2: Negative capacity ---
        try {
            PassengerBogie bogie2 = new PassengerBogie("AC Chair", -10);
            System.out.println("Test 2 Failed: Created bogie with negative capacity!");
            failed++;
        } catch (InvalidCapacityException e) {
            System.out.println("Test 2 Passed: " + e.getMessage());
            passed++;
        }

        // --- Test 3: Zero capacity ---
        try {
            PassengerBogie bogie3 = new PassengerBogie("First Class", 0);
            System.out.println("Test 3 Failed: Created bogie with zero capacity!");
            failed++;
        } catch (InvalidCapacityException e) {
            System.out.println("Test 3 Passed: " + e.getMessage());
            passed++;
        }

        // --- Test 4: Multiple valid bogies ---
        try {
            List<PassengerBogie> list = new ArrayList<>();
            list.add(new PassengerBogie("Sleeper", 60));
            list.add(new PassengerBogie("AC Chair", 50));
            list.add(new PassengerBogie("First Class", 30));
            System.out.println("Test 4 Passed: Multiple bogies created successfully");
            passed++;
        } catch (InvalidCapacityException e) {
            System.out.println("Test 4 Failed: " + e.getMessage());
            failed++;
        }

        System.out.println("\nSummary: Passed = " + passed + ", Failed = " + failed);
    }
}