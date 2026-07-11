package P1;
import java.util.*;

public class Solution20 {
    public static void main(String[] args){
        int st = 10;
        int end = 222;
        int k = 2;

        int cnt = 0;

        for(int i=st ;i<=end; i++){
            int rem = i % 10;
            if(rem == k){
                System.out.print(i + " ");
            }
        }
    }
}
