import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BogieService {

    // UC8: Filter by capacity
    public List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // UC9: Group by type
    public Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    // UC10: Total capacity
    public int getTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // UC16: Sort passenger bogie capacities using Bubble Sort
    public int[] sortPassengerBogieCapacities(int[] capacities) {
        if (capacities == null) {
            return null;
        }

        int[] sorted = new int[capacities.length];
        for (int i = 0; i < capacities.length; i++) {
            sorted[i] = capacities[i];
        }

        for (int pass = 0; pass < sorted.length - 1; pass++) {
            for (int index = 0; index < sorted.length - 1 - pass; index++) {
                if (sorted[index] > sorted[index + 1]) {
                    int temp = sorted[index];
                    sorted[index] = sorted[index + 1];
                    sorted[index + 1] = temp;
                }
            }
        }

        return sorted;
    }
}