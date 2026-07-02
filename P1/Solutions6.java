package P1;

import java.util.*;


public class Solutions6 {
    public static void findLeaders(int[] arr) {
    
        Stack<Integer> st= new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            st.push(arr[i]);
        }

        Collections.sort(st);

        for(int x : st){
            System.out.print(x+" ");
        }
        
    }


    public static void main(String[] args) {
        int[] arr = {16, 19, 4, 3, 8, 3};
        findLeaders(arr);
    }
}

// {16, 19, 4, 3, 8, 3}