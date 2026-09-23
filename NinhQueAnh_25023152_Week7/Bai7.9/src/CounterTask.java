public class CounterTask implements Runnable {
    private Counter counter;
    private boolean useTryLock;

    public CounterTask(Counter counter, boolean useTryLock) {
        this.counter = counter;
        this.useTryLock = useTryLock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (useTryLock) {
                counter.incrementWithTryLock();
            } else {
                counter.increment();
            }
        }
    }
}
