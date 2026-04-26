import java.util.Arrays;
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

    // UC17: Sort bogie type names using Arrays.sort()
    public String[] sortBogieNames(String[] names) {
        if (names == null) {
            return null;
        }

        String[] sorted = Arrays.copyOf(names, names.length);
        Arrays.sort(sorted);
        return sorted;
    }

    // UC18: Linear search for bogie ID in an unsorted array
    public boolean searchBogieById(String[] bogieIds, String searchId) {
        if (bogieIds == null || searchId == null) {
            return false;
        }

        for (String id : bogieIds) {
            if (searchId.equals(id)) {
                return true;
            }
        }

        return false;
    }

    // UC19: Binary search for bogie ID in a sorted array
    public boolean binarySearchBogieById(String[] bogieIds, String searchId) {
        if (bogieIds == null || searchId == null) {
            return false;
        }

        String[] sortedIds = Arrays.copyOf(bogieIds, bogieIds.length);
        Arrays.sort(sortedIds);

        int low = 0;
        int high = sortedIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchId.compareTo(sortedIds[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}