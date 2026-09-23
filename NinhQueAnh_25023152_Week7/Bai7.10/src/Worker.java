public class Worker implements Runnable {

    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Worker bị gián đoạn");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Worker đã dừng.");
    }
}
