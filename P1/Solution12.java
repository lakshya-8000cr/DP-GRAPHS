package P1;

import java.util.ArrayList;

public class Solution12 {
    public static void printSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        
        int r = matrix.length;
        int c = matrix[0].length;

        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;

        while(top<=bottom && left<=right){
            for(int i=left; i<=right; i++){
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for(int i=top; i<=bottom; i++){
                System.out.print(matrix[i][right] + " ");
            }
            right--;


            if(top<=bottom){
            for(int i=right; i>=left; i--){
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;
            }

            if(left<=right){
            for(int i=bottom; i>=top; i--){
                System.out.print(matrix[i][left] + " ");
            }
            left++;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        printSpiral(matrix);
        // Expected Clockwise Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    }
}