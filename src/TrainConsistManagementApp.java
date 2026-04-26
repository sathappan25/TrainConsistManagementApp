import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("====================================");
        System.out.println();

        String[] bogieIds = { "BG309", "BG101", "BG550", "BG205", "BG412" };
        System.out.println("Bogie IDs (unsorted): " + Arrays.toString(bogieIds));

        String searchId = "BG205";
        System.out.println("Searching for bogie ID: " + searchId);

        BogieService bogieService = new BogieService();
        boolean found = bogieService.binarySearchBogieById(bogieIds, searchId);

        if (found) {
            System.out.println("Result: Bogie ID " + searchId + " exists in the sorted consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchId + " was not found.");
        }

        System.out.println();
        System.out.println("Binary Search demonstration completed.");
        System.out.println("Program continues...");
    }
}