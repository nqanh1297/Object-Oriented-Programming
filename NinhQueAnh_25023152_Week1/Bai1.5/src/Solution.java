public class Solution {
    public int gcd(int a,int b) {
        if (a==0) return Math.abs(b);
        if (b==0) return Math.abs(a);

        a=Math.abs(a);
        b=Math.abs(b);

        while(b!=0) {
            int temp=b;
            b=a%b;
            a=temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.gcd(28,18));
        System.out.println(sol.gcd(9,12));

    }
}
