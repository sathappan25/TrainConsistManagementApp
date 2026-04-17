import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Train Consist Management App");
        System.out.println("============================\n");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: "+trainConsist.size());
        System.out.println("Current Train Consist: "+trainConsist);
        System.out.println("System ready for operations...");
    }
}