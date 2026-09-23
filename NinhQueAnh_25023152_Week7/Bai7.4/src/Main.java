public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        store.addBook("Java", 10);
        store.addBook("Python", 8);
        store.addBook("DSA", 5);

        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                store.getStock("Java");
                sleep(500);
            }
        }, "Reader-1");

        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                store.getStock("Python");
                sleep(500);
            }
        }, "Reader-2");

        Thread reader3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                store.getStock("DSA");
                sleep(500);
            }
        }, "Reader-3");

        Thread writer1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                store.borrow("Java", 2);
                sleep(700);
            }
        }, "Writer-1");

        Thread writer2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                store.addBook("DSA", 3);
                sleep(900);
            }
        }, "Writer-2");

        reader1.start();
        reader2.start();
        reader3.start();
        writer1.start();
        writer2.start();

        try {
            reader1.join();
            reader2.join();
            reader3.join();
            writer1.join();
            writer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Tồn kho cuối cùng ===");
        store.getStock("Java");
        store.getStock("Python");
        store.getStock("DSA");
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}