import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số đơn hàng: ");
        int n = sc.nextInt();

        List<String> ids = new ArrayList<>();
        List<Long> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nĐơn hàng thứ " + (i + 1) + ":");

            System.out.print("Nhập id: ");
            String id = sc.next();

            System.out.print("Nhập processMs: ");
            long processMs = sc.nextLong();

            ids.add(id);
            times.add(processMs);
        }

        OrderProcessor processor = new OrderProcessor(3);

        processor.processOrders(ids, times);
        processor.printResult();
        processor.shutdown();

        sc.close();
    }
}