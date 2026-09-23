public class Solution {
    public int sumOfDigits(int n) {
        n=Math.abs(n);
        int sum=0;
        while(n!=0) {
            sum=sum+n%10;
            n=n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfDigits(123));
        System.out.println(sol.sumOfDigits(191));
        System.out.println(sol.sumOfDigits(21));
    }
}
