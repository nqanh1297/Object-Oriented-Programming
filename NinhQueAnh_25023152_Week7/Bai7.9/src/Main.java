public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        boolean useTryLock = false;

        Thread t1 = new Thread(new CounterTask(counter, useTryLock), "Thread-1");
        Thread t2 = new Thread(new CounterTask(counter, useTryLock), "Thread-2");
        Thread t3 = new Thread(new CounterTask(counter, useTryLock), "Thread-3");
        Thread t4 = new Thread(new CounterTask(counter, useTryLock), "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main bị gián đoạn");
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter = " + counter.getValue());
    }
}
