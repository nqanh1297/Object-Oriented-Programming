import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeFilterTask implements Callable<List<Integer>> {
    private int[] arr;

    public PrimeFilterTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();

        for (int num : arr) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes;
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