import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private ExecutorService executor;
    private List<String> logs;
    private AtomicInteger successCount;

    public OrderProcessor(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
        this.logs = new ArrayList<>();
        this.successCount = new AtomicInteger(0);
    }

    public void processOrders(List<String> ids, List<Long> times) {
        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            OrderTask task = new OrderTask(ids.get(i), times.get(i), logs);
            Future<Boolean> future = executor.submit(task);
            futures.add(future);
        }

        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    successCount.incrementAndGet();
                }
            } catch (Exception e) {
                System.out.println("Lỗi khi lấy kết quả task: " + e.getMessage());
            }
        }
    }

    public void printResult() {
        System.out.println("\nSuccess = " + successCount.get());
        System.out.println("Logs theo thứ tự hoàn thành:");
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}