package P1;

public class Solution14 {
    public static void main(String[] args){
        int[] arr = {9, 7, 5, 10, 3, 2};
        int max = -1;
        int left = 0;
        int right = 1;
        boolean f = false;

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                // int diff = Math.abs(arr[i] - arr[j]);
                if(arr[j] > arr[i]){
                    int diff = arr[j] - arr[i];
                    if(diff>max){
                        max = diff;
                    }
                }
            }
        }

        System.out.print(max);
    }
}
