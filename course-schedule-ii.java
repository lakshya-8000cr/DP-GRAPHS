/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //same logic as the topo sort availbael or npt
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            ls.add(new ArrayList<>());
        } 

        int[] indegree = new int[numCourses];

        //populate
        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];

            ls.get(b).add(a);
            indegree[a]++;
        }

        int[] ans = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }  

        int c = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[c++] = curr;

            for(int neigh : ls.get(curr)){
                //decrease the indegree of the neighbour of curr;
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }

        if(c==numCourses){
            return ans; 
        }

        return new int[0];
    }
}
// @lc code=end

