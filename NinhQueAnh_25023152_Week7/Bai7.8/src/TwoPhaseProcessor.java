import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TwoPhaseProcessor {
    private ExecutorService phase1Pool;
    private ExecutorService phase2Pool;

    public TwoPhaseProcessor(int phase1Size, int phase2Size) {
        this.phase1Pool = Executors.newFixedThreadPool(phase1Size);
        this.phase2Pool = Executors.newFixedThreadPool(phase2Size);
    }

    public void process(List<int[]> arrays) {
        List<Future<List<Integer>>> phase1Futures = new ArrayList<>();

        for (int[] arr : arrays) {
            PrimeFilterTask task = new PrimeFilterTask(arr);
            phase1Futures.add(phase1Pool.submit(task));
        }

        List<List<Integer>> phase1Results = new ArrayList<>();


        for (int i = 0; i < phase1Futures.size(); i++) {
            try {
                List<Integer> primes = phase1Futures.get(i).get();
                phase1Results.add(primes);
                System.out.println("Array " + i + " - primes = " + primes);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main bị gián đoạn ở giai đoạn 1");
                return;
            } catch (ExecutionException e) {
                System.out.println("Lỗi giai đoạn 1 tại mảng " + i + ": " + e.getMessage());
                phase1Results.add(new ArrayList<>());
            }
        }

        List<Future<Long>> phase2Futures = new ArrayList<>();


        for (List<Integer> primes : phase1Results) {
            PrimeProcessTask task = new PrimeProcessTask(primes);
            phase2Futures.add(phase2Pool.submit(task));
        }

        long total = 0;


        for (int i = 0; i < phase2Futures.size(); i++) {
            try {
                long value = phase2Futures.get(i).get();
                System.out.println("Array " + i + " - phase 2 result = " + value);
                total += value;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main bị gián đoạn ở giai đoạn 2");
                return;
            } catch (ExecutionException e) {
                System.out.println("Lỗi giai đoạn 2 tại mảng " + i + ": " + e.getMessage());
            }
        }

        System.out.println("Total = " + total);
    }

    public void shutdown() {
        phase1Pool.shutdown();
        phase2Pool.shutdown();
    }
}