package basic;
import java.util.*;
public class hash {
    public static void main(){
        HashMap<Integer , Integer> mp = new LinkedHashMap<>();

        for(int i=0; i<n; i++){
            int val = arr[i];

            if(!mp.containsKey(val)){
                mp.put(val,1);
            }
            else{
                mp.put(val,map.get(val)+1);
            }

        }

        for(int i : mp.keySet()){
            int val = mp.get(i);

            if(val==1)return i;
        }
    }
}
