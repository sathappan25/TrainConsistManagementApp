import java.util.List;
import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Maintain Ordered Bogie Consist");
        System.out.println("============================\n");
        List<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");
        trainConsist.add(2, "Pantry Car");
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println(trainConsist);
    }
}