package P1;

public class Solution2 {
    public static void printShiftPattern(int n, int s) {
        
        for(int i=0; i<n-1; i++){
            for(int j=0; j<=i; j++){
                System.out.print(s);
            }
            s++;
            System.out.println();
        }

        int temp = s-1;
                
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                System.out.print(temp);
            }
            temp--;
            System.out.println();
        }

    }

    public static void main(String[] args) {
        printShiftPattern(4, 3);
    }
}