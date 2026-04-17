import java.util.Set;
import java.util.LinkedHashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Preserve Insertion Order of Bogies");
        System.out.println("============================\n");
        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");
        System.out.println("Final Train Formation: \n");
        System.out.println(formation);
    }
}