public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t = new Thread(worker);

        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main bị gián đoạn");
            Thread.currentThread().interrupt();
        }

        worker.stop();

        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Main bị gián đoạn khi join");
            Thread.currentThread().interrupt();
        }

        System.out.println("Main kết thúc.");
    }
}
