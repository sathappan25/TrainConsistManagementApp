import java.util.Map;
import java.util.HashMap;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Map Bogie to Capacity (HashMap)");
        System.out.println("============================\n");
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        System.out.println("Bogie Capacity Details:\n");
        for(Map.Entry<String, Integer> entry : capacityMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}