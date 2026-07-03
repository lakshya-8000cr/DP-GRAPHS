package P1;

import java.util.ArrayList;
import java.util.Stack;

public class Solution13 {
    public static int rowWithMaxZeros(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return -1;

        int r = matrix.length;
        int c = matrix[0].length;

        java.util.Stack<Integer> st = new java.util.Stack<>();
        java.util.Map<Integer, Integer> ls = new java.util.LinkedHashMap<>();
        for(int i=0; i<matrix.length; i++){
            int cnt = 0;
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                   cnt++;
                }
            }

            ls.put(i , cnt);
        }

        int max = 0;
        int k = 0;

        for(int x : ls.keySet()){
            int vl = ls.get(x);

            if(vl>max){
                max = vl;
                k=x;
            }

        }
        return k; // Return the index of the row with max 0s
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 1},
            {0, 0, 0, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        System.out.println(rowWithMaxZeros(matrix)); // Expected Output: 1
    }
}
