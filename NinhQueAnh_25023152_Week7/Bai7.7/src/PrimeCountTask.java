import java.util.concurrent.Callable;

public class PrimeCountTask implements Callable<Integer> {
    private int[] arr;
    private int index;

    public PrimeCountTask(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public Integer call() {
        int count = 0;

        for (int num : arr) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}