public class Solution {

    public static long fibonnaci(long n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1, result = 0;

        for (long i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - b < a)
                return Long.MAX_VALUE;

            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonnaci(5));
        System.out.println(fibonnaci(12));
        System.out.println(fibonnaci(-1));

    }
}