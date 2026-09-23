import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];

            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }

            arrays.add(arr);
        }

        PrimeArrayProcessor processor = new PrimeArrayProcessor(n);
        processor.processArrays(arrays);
        processor.shutdown();

        sc.close();
    }
}