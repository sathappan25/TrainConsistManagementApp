import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceComparisonApp {

    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== UC13: Performance Comparison (Loops vs Streams) ===");

        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int capacity = 20 + (i % 81); // 20-100
            bogies.add(new PassengerBogie("Sleeper", capacity));
        }

        // Loop-based filtering
        long startLoop = System.nanoTime();
        List<PassengerBogie> filteredLoop = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                filteredLoop.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long elapsedLoop = endLoop - startLoop;

        System.out.println("Loop-based filtered bogies count: " + filteredLoop.size());
        System.out.println("Loop-based execution time (ns): " + elapsedLoop);

        // Stream-based filtering
        long startStream = System.nanoTime();
        List<PassengerBogie> filteredStream = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long elapsedStream = endStream - startStream;

        System.out.println("Stream-based filtered bogies count: " + filteredStream.size());
        System.out.println("Stream-based execution time (ns): " + elapsedStream);

        // Compare
        System.out.println("Loop and Stream results match? " + 
            (filteredLoop.size() == filteredStream.size()));
    }
}