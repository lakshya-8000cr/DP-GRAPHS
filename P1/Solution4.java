package P1;

public class Solution4 {
    public static void printTrapeziumPattern(int n) {

        int q = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n-i; j++){
                System.out.print("-");
            }

            for(int j=0; j<2*i-1; j++){
                System.out.print(q);
                q++;
            }
        }

    }

    public static void main(String[] args) {
        int n = 4;
        printTrapeziumPattern(n);
    }
}


// 1*2*3*4*17*18*19*20
// --5*6*7*14*15*16
// ----8*9*12*13
// ------10*11