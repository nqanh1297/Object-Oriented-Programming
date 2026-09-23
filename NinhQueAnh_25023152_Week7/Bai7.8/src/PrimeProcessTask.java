import java.util.List;
import java.util.concurrent.Callable;

public class PrimeProcessTask implements Callable<Long> {
    private List<Integer> primes;

    public PrimeProcessTask(List<Integer> primes) {
        this.primes = primes;
    }

    @Override
    public Long call() {
        long sum = 0;

        if (primes.size() % 2 == 0) {
            for (int x : primes) {
                sum += 1L * x * x;
            }
        } else {
            for (int x : primes) {
                sum += 1L * x * x * x;
            }
        }

        return sum;
    }
}
