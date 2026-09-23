package demo.thread;

public class Task implements Runnable {
    private String name;
    private long duration;

    public Task(String name, long duration) {
        this.name=name;
        this.duration=duration;
    }
    @Override
    public void run() {
        System.out.println("Start "+name);

        try {
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            System.out.println(name +" bị gián đoạn");
        }
        System.out.println("End "+name);
    }
}
