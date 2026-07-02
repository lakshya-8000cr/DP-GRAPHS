package P1;

public class Solution3 {
    public static void printZigZagPattern(int n) {

        int num = 1;
        
        for(int i=1; i<=n; i++){
            if(i % 2 != 0){
                for(int j=1 ; j<=i; j++){
                    System.out.print(num);
                    num++;
                }
            }
            else{
                int temp = num + i - 1;
                for(int j=1; j<=i; j++){
                    System.out.print(temp);
                    temp--;
                    num++;
                } 
            }

                    System.out.println();
        }

        
    }

    public static void main(String[] args) {
        printZigZagPattern(4);
    }
}

// 1
// 3 2
// 4 5 6
// 10 9 8 7