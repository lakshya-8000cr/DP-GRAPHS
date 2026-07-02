package P1;

public class Solution7 {
    public static int findEquilibrium(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int left = 0;
            int right = 0 ;
            int sum = 9;

            left += arr[i];
            right = sum - left;

            if(left>right){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2 , 3 , 2 , 1};
        System.out.println(findEquilibrium(arr));
    }
}