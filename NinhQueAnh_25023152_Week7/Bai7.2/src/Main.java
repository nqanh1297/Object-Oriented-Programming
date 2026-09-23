import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumTask implements Callable<Integer> {
    private int[] arr;
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        System.out.println("Đoạn [" + start + ", " + (end - 1) + "] có tổng = " + sum);
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập " + n + " phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Nhập số đoạn k: ");
        int k = sc.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> futures = new ArrayList<>();

        int chunkSize = (n + k - 1) / k;

        for (int i = 0; i < k; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n);

            if (start < n) {
                SumTask task = new SumTask(arr, start, end);
                Future<Integer> future = executor.submit(task);
                futures.add(future);
            }
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                totalSum += future.get();
            } catch (InterruptedException e) {
                System.out.println("Luồng chính bị gián đoạn");
            } catch (ExecutionException e) {
                System.out.println("Lỗi khi thực hiện task: " + e.getMessage());
            }
        }

        System.out.println("Tổng cuối cùng của mảng = " + totalSum);

        executor.shutdown();
        sc.close();
    }
}