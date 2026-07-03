package P1;

import java.util.Arrays;

public class Solution9 {
    public static void alternateSort(int[] arr) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            if(left==right){
                System.out.print(arr[left] + " ");
            }
            else{
            System.out.print(arr[right] + " " + arr[left] + " ");
            }
            right--;
            left++;
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 7, 9};
        alternateSort(arr);
    }
}
