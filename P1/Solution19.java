package P1;
import java.util.*;

public class Solution19 {
    public static void main(String[] args){
        String e = "abeabutiedcia";
        HashMap<Character , Integer> mp = new HashMap<>();
        for(int i=0; i<e.length(); i++){
            char ch = e.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch , 1);
            }
            else{
                mp.put(ch , mp.get(ch) + 1);
            }
        }

        int max = 0;
        char c = ' ';
        for(char x : mp.keySet()){
            int val = mp.get(x);
            
            if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u'){
                if(val > max){
                    max = val;
                    c = x;
                }
            }
        }

        System.out.print(c + "->" + max);
    }
}
