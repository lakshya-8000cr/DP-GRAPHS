/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        // we will use the simple approach or this question 
        // just find out the indegree of the nodes , if the indegree of the any node ==n-1 then that is town judge

        //prepare the list
        List<List<Integer>> ls = new LinkedList<>();
        int[] outdegree = new int[n+1];
        
        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }

        //populate the list
        for(int[] edge : trust ){
            int u = edge[0];
            int v = edge[1];

            ls.get(v).add(u);
            outdegree[u]++;
        }

        // now store the indegree
        int maxindegre = 0;
        int judge = 0;

        int a = trust.length;
        for(int i=1; i<=n; i++){
            int indeg = ls.get(i).size();

            if(indeg==n-1 && outdegree[i]==0){
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

