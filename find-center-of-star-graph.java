/*
 * @lc app=leetcode id=1791 lang=java
 *
 * [1791] Find Center of Star Graph
 */

// @lc code=start
class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;

        // our approach on this ques will br
        // find out degree of each node

        //prepare a list
        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }   

        // now populate the graph

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            ls.get(u).add(v);
            ls.get(v).add(u);
        }

        int maxoutdegree = 0;
        int outnod = 0;

        for(int i=0; i<=n; i++){
            int outdeg = ls.get(i).size();
            if(outdeg > maxoutdegree){
                maxoutdegree = outdeg;
                outnod = i;
            }
        }

        return outnod;

    }
}
// @lc code=end

