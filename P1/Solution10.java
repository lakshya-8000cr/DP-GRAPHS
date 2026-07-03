package P1;

public class Solution10 {
    public static void searchMatrix(int[][] matrix, int target) {

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == target){
                    System.out.print(i + " " + j);
                    return ;
                }
            }
        }

        System.out.print(-1);
        
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int target = 29;
        searchMatrix(matrix, target);
    }
}
