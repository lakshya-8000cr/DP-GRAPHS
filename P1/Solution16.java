package P1;
import java.util.*;

public class Solution16 {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,2,3,4,4,5,5,5,5,6,7,7};
        HashMap<Integer , Integer> mp = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i] , 1);
            }
            else{
                mp.put(arr[i] , mp.get(arr[i]) + 1);
            }
        }

        int sum = 0;

        for(int key : mp.keySet()){
            int val = mp.get(key);

            if(val % 2 != 0){
                sum += key;
            }
        }

        System.out.print(sum);
    }
}
