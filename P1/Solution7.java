package P1;


public class Solution7 {
    public static int findEquilibrium(int[] arr) {

        int sum = 0;
        for(int x :arr){
            sum += x;
        }

            int left = 0;

        for(int i=0; i<arr.length; i++){
            int right = sum - left - arr[i];

            if(left==right)return i;

            left += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(findEquilibrium(arr));
    }
}