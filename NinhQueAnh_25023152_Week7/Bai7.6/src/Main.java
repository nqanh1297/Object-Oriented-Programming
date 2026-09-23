import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số mảng n: ");
        int n = sc.nextInt();

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số phần tử của mảng " + (i + 1) + ": ");
            int size = sc.nextInt();

            int[] arr = new int[size];
            System.out.println("Nhập " + size + " phần tử:");
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }

            arrays.add(arr);
        }

        ArrayProcessor processor = new ArrayProcessor(n);
        processor.processArrays(arrays);
        processor.shutdown();

        sc.close();
    }
}
