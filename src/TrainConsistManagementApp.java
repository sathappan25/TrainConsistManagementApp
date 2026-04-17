import java.util.Set;
import java.util.HashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Track Unique Bogie IDs");
        System.out.println("============================\n");
        Set<String> bogies = new HashSet<>();
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        bogies.add("BG101");
        bogies.add("BG102");
        System.out.println("Bogie IDs After Insertion:\n");
        System.out.println(bogies);
    }
}