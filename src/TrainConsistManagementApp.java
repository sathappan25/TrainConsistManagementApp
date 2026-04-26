import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("====================================");
        System.out.println();

        String[] bogieIds = new String[0];
        System.out.println("Bogie IDs: " + Arrays.toString(bogieIds));

        String searchId = "BG101";
        System.out.println("Searching for bogie ID: " + searchId);

        BogieService bogieService = new BogieService();
        try {
            boolean found = bogieService.searchBogieById(bogieIds, searchId);
            System.out.println("Result: Bogie ID " + searchId + (found ? " exists." : " was not found."));
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println();
        System.out.println("Exception handling demonstration completed.");
        System.out.println("Program continues...");
    }
}