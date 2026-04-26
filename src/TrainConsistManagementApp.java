import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("====================================");
        System.out.println();

        String[] bogieNames = { "Sleeper", "AC Chair", "First Class", "General", "Luxury" };
        System.out.println("Unsorted bogie names: " + Arrays.toString(bogieNames));

        BogieService bogieService = new BogieService();
        String[] sortedNames = bogieService.sortBogieNames(bogieNames);

        System.out.println("Sorted bogie names:   " + Arrays.toString(sortedNames));
        System.out.println();
        System.out.println("Arrays.sort() demonstration completed.");
        System.out.println("Program continues...");
    }
}