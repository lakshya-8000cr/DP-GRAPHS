package P1;
import java.util.*;

public class Solution18 {
    public static void main(String[] args){
        int n = 844844071;
        int sum = 0;

        while(n>0){
            int rem = n % 10;
            sum += rem;
            n = n / 10;

            if(n==0 && sum>9){
                n = sum;
                sum = 0;
            }
        }

        System.out.print(sum);
    }
}
