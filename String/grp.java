class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // we can do this in normal brute force , but we need to find something optimal
        // step sort all the word inside the arr ,then use hashmapo
        // if map donot contains that word befor , then create a new list for that word
        // aftet that using get function , get the list of that word then add that word in that list
        HashMap<String , List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sor = new String(arr);

            if(!map.containsKey(sor)){
                map.put(sor , new ArrayList<>());
            }

            map.get(sor).add(word);
        }

        
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;

    }
}