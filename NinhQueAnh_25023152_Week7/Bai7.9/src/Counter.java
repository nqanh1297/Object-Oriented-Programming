import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    public void incrementWithTryLock() {
        if (lock.tryLock()) {
            try {
                value++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " không lấy được lock");
        }
    }

    public int getValue() {
        return value;
    }
}
