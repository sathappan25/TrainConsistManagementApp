import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC16 - Sort Passenger Bogies by Capacity");
        System.out.println("====================================");
        System.out.println();

        int[] passengerCapacities = { 72, 56, 24, 70, 60 };
        System.out.println("Unsorted passenger bogie capacities: " + Arrays.toString(passengerCapacities));

        BogieService bogieService = new BogieService();
        int[] sortedCapacities = bogieService.sortPassengerBogieCapacities(passengerCapacities);

        System.out.println("Sorted passenger bogie capacities:   " + Arrays.toString(sortedCapacities));
        System.out.println();
        System.out.println("Bubble Sort demonstration completed.");
        System.out.println("Program continues...");
    }
}