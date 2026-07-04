/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
import java.util.*;
class Solution {

    public boolean isCycle(int src , boolean[] visit , List<List<Integer>>ls){
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{src , -1});
        visit[src] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for(int neigh : ls.get(node)){
                if(!visit[neigh]){
                    q.add(new int[]{neigh , node});
                    visit[neigh] = true;
                }

                else if(visit[neigh]==true && parent!=neigh){
                    return true;
                }
            }
        }

        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        // first make the adjancy list
        int n = edges.length;
        List<List<Integer>> ls  = new ArrayList<>();

        for(int i=0; i<=n; i++){
           ls.add(new ArrayList<>());   
        }

        //we have toe return the edge , pair we can say so we will use all logic in inside the loop of the edge
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            ls.get(v).add(u);
            ls.get(u).add(v); // added all the elements;

            // 1-> make a visit , 2->handle the unconnected 
            boolean[] visit = new boolean[n+1];
            for(int i=1; i<=n; i++){
                if(!visit[i]){
                   if(isCycle(i , visit , ls )){
                    return edge;
                   }
                }
            }
        }

        return new int[0];
    }
}
// @lc code=end

