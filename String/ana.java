class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character , Integer> map = new HashMap<>(); // use the hashmap for the frequeqny
        HashMap<Character , Integer> map2 = new HashMap<>(); // use the hashmap for the frequeqny

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch , 1);
            }
            else{
                map.put(ch , map.get(ch)+1);
            }
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map2.containsKey(ch)){
                map2.put(ch , 1);
            }
            else{
                map2.put(ch , map2.get(ch)+1);
            }
        }

        for(char ch : map.keySet()){
            int v1 = map.get(ch);
            for(char ch2 : map2.keySet()){
                int v2 = map2.get(ch2);

                if(ch!=ch2 || v1!=v2){
                    return false;
                }
            }
        }

       return true;
    }
}