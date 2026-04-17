import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagementApp {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Train Consist Management App");
        System.out.println("============================\n");
        System.out.println("============================\n");
        System.out.println("Add Passenger Bogies to Train");
        System.out.println("============================\n");
        List<String> trainConsist = new ArrayList<>();
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("After Adding Bogies: \n");
        System.out.println("Passenger Bogies: " + passengerBogies);
        System.out.println("After Removing "+ passengerBogies.remove(1));
        System.out.println("Passenger Bogies: " + passengerBogies);
        System.out.println("Checking if 'Sleeper' exists: \n");
        System.out.println("Contains Sleeper?: " + passengerBogies.contains("Sleeper"));
        System.out.println("Final Train Passenger Consist:\n " + passengerBogies);
    }
}