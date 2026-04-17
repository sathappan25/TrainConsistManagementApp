import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("============================");
        System.out.println("Sort Bogies by Capacity");
        System.out.println("============================\n");

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        System.out.println("Before Sorting:\n");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting (by Capacity):\n");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }
    }
}