package P1;
import java.util.*;

public class Solution15 {
    public static void main(String[] args){
        String st = "aaaaabbbccccccccdaa";
        HashMap<Character , Integer> mp = new LinkedHashMap<>();

        int cnt = 1;
        String ans ="";
        for(int i=0; i<st.length(); i++){
            if(i+1<st.length() && st.charAt(i) == st.charAt(i+1)){
                cnt++;
            }
            else{
                if(cnt==1)ans += st.charAt(i);
                else{
                ans += st.charAt(i);
                ans += cnt;
    
                }
            }
        }
        System.out.print(ans);
    }
}
