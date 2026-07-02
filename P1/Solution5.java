package P1;
public class Solution5 {
    public static void printPascalTriangle(int n) {
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            int val = 1;

            for(int j=1; j<=i; j++){
               System.out.print(val + " ");

               val = val * (i-j)/j;
            }
 
            System.out.println();

        }
        
    }

    public static void main(String[] args) {
        int n = 5;
        printPascalTriangle(n);
    }
}
