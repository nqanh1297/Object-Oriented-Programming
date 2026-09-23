public class Solution {
    public boolean isPalindrome(int n) {
        if (n<0) {
            return false;
        }
        int original=n;
        int reversed=0;
        while(n!=0) {
            int digit=n%10;
            reversed=reversed*10+digit;
            n=n/10;
        }
        return original==reversed;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = {-121, 0, 5, 10, 121, 12321, 123};
        for(int n: test) {
            System.out.println(n+" -> "+ sol.isPalindrome(n));
        }

    }
}
