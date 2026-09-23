public class Solution {
    public int reverse(int n) {
        int reversed=0;
        while(n!=0) {
            int digit=n%10;
            reversed=reversed*10+digit;
            n=n/10;
        }
        return reversed;
    }
    public static void main(String[] args) {
        Solution sol=new Solution();
        System.out.println(sol.reverse(10));
        System.out.println(sol.reverse(129));
        System.out.println(sol.reverse(254));
    }
}
