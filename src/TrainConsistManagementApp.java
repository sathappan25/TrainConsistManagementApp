import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("====================================");
        System.out.println();

        String[] bogieIds = { "BG101", "BG205", "BG309", "BG412", "BG550" };
        System.out.println("Bogie IDs: " + Arrays.toString(bogieIds));

        String searchId = "BG309";
        System.out.println("Searching for bogie ID: " + searchId);

        BogieService bogieService = new BogieService();
        boolean found = bogieService.searchBogieById(bogieIds, searchId);

        if (found) {
            System.out.println("Result: Bogie ID " + searchId + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchId + " was not found.");
        }

        System.out.println();
        System.out.println("Linear Search demonstration completed.");
        System.out.println("Program continues...");
    }
}