import java.util.List;
import java.util.concurrent.Callable;

public class OrderTask implements Callable<Boolean> {
    private String id;
    private long processMs;
    private List<String> logs;

    public OrderTask(String id, long processMs, List<String> logs) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
    }

    @Override
    public Boolean call() {
        System.out.println("Start " + id);

        try {
            Thread.sleep(processMs);
        } catch (InterruptedException e) {
            System.out.println("Order " + id + " bị gián đoạn");
            Thread.currentThread().interrupt();
            return false;
        }

        boolean success = processMs <= 1500;
        String result = success ? "DONE " + id : "FAIL " + id;

        synchronized (logs) {
            logs.add(result);
        }

        return success;
    }
}