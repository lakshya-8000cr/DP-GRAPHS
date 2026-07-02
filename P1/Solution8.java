package P1;

import java.util.LinkedHashMap;

public class Solution8 {
    public static int maxSubArraySum(int[] arr) {
        
        java.util.HashMap<Integer , Integer> mp = new java.util.LinkedHashMap<>();

        int maxsum = 0;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum = Math.max(arr[i] , sum + arr[i]);

            maxsum = Math.max(maxsum , sum );
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(arr)); // Expected Output: 6
    }
}
