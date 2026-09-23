import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookStore {
    private Map<String, Integer> stock = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addBook(String title, int qty) {
        lock.writeLock().lock();
        try {
            int currentQty = stock.getOrDefault(title, 0);
            stock.put(title, currentQty + qty);
            System.out.println(Thread.currentThread().getName()
                    + " thêm " + qty + " cuốn [" + title + "], tồn kho = " + stock.get(title));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            int currentQty = stock.getOrDefault(title, 0);

            if (currentQty >= qty) {
                stock.put(title, currentQty - qty);
                System.out.println(Thread.currentThread().getName()
                        + " mượn " + qty + " cuốn [" + title + "], còn lại = " + stock.get(title));
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " muốn mượn " + qty + " cuốn [" + title + "] nhưng không đủ sách. Hiện có = " + currentQty);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getStock(String title) {
        lock.readLock().lock();
        try {
            int qty = stock.getOrDefault(title, 0);
            System.out.println(Thread.currentThread().getName()
                    + " đọc tồn kho [" + title + "] = " + qty);
            return qty;
        } finally {
            lock.readLock().unlock();
        }
    }
}