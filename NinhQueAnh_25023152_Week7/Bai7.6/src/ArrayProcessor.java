import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ArrayProcessor {
    private ExecutorService executor;

    public ArrayProcessor(int poolSize) {
        executor = Executors.newFixedThreadPool(poolSize);
    }

    public void processArrays(List<int[]> arrays) {
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < arrays.size(); i++) {
            SecondLargestTask task = new SecondLargestTask(arrays.get(i), i + 1);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        int total = 0;

        for (int i = 0; i < futures.size(); i++) {
            try {
                int result = futures.get(i).get();
                System.out.println("Mảng " + (i + 1) + " -> số lớn thứ hai = " + result);
                total += result;
            } catch (ExecutionException e) {
                System.out.println("Bỏ qua mảng " + (i + 1) + ": " + e.getCause().getMessage());
            } catch (InterruptedException e) {
                System.out.println("Luồng chính bị gián đoạn.");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Tổng cuối cùng = " + total);
    }

    public void shutdown() {
        executor.shutdown();
    }
}