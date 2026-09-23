public class Solution {
    public int secondLargest(int[] arr) {
        if ( arr == null || arr.length<2 ) {
            return -1;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for ( int num: arr) {
            if(num>max1) {
                max2=max1;
                max1=num;
            }
            else if (num>max2 && num<max1) {
                max2=num;
            }
        }
        if (max2==Integer.MIN_VALUE){
            return -1;
        }
        return max2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tests = {
                {1,2,3,4,5},
                {5,5,5},
                {10},
                {-1,-5,-3},
                {7,7,8,8,6}
        };
        for (int[] arr:tests) {
            System.out.println("Second largest: "+ sol.secondLargest(arr));
        }
    }
}
