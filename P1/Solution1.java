package P1;

public class Solution1 {
    public static void printCustomDiamond(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
                
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        int n = 4;
        printCustomDiamond(n);
    }
}