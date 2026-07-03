package P1;

import java.util.*;

public class Solution11 {
    public static void rotateRight(int[] arr, int k) {

        if(k==0)k=-1;

        ArrayList<Integer> ls1 = new ArrayList<>();
        ArrayList<Integer> ls2 = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(i<=k){
                ls1.add(arr[i]);
            }
            else{
                ls2.add(arr[i]);
            }
        }

        ArrayList<Integer> ls = new ArrayList<>();

        ls.addAll(ls2);
        ls.addAll(ls1);

        for(int i=0; i<arr.length; i++){
            arr[i] = ls.get(i);
        }

        for(int x : arr){
            System.out.print(x + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 0;
        
        rotateRight(arr, k);
        
        // System.out.println(Arrays.toString(arr)); // Should print your rotated array
    }
}