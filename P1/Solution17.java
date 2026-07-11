package P1;
import java.util.*;

public class Solution17 {
    public static void main(String[] args){
        String e = "hello! 1123";
        int cnt = 0;

        for(int i=0; i<e.length(); i++){
            char ch = e.charAt(i);

            if(ch >='a' && ch <='z'){
                cnt++;
            }
            else if(ch >= '0' && ch<='9'){
                cnt++;
            }

        }

        System.out.print(cnt);
    }
}
