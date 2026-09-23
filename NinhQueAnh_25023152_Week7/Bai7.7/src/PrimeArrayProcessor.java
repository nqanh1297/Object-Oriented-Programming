import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeArrayProcessor {
    private ExecutorService executor;

    public PrimeArrayProcessor(int poolSize) {
        executor = Executors.newFixedThreadPool(poolSize);
    }

    public void processArrays(List<int[]> arrays) {
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < arrays.size(); i++) {
            PrimeCountTask task = new PrimeCountTask(arrays.get(i), i);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        int maxPrimeCount = -1;
        int bestArrayIndex = -1;

        for (int i = 0; i < futures.size(); i++) {
            try {
                int primeCount = futures.get(i).get();
                System.out.println("Array " + i + ": " + primeCount);

                if (primeCount > maxPrimeCount) {
                    maxPrimeCount = primeCount;
                    bestArrayIndex = i;
                }
            } catch (InterruptedException e) {
                System.out.println("Luồng chính bị gián đoạn.");
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.out.println("Lỗi khi xử lý mảng " + i + ": " + e.getMessage());
            }
        }

        System.out.println("Max prime count = " + maxPrimeCount);
        System.out.println("Best array index = " + bestArrayIndex);
    }

    public void shutdown() {
        executor.shutdown();
    }
}