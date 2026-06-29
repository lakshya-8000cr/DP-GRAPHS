/*
 * @lc app=leetcode id=1971 lang=java
 *
 * [1971] Find if Path Exists in Graph
 */

// @lc code=start
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

     List<List<Integer>> graph = new ArrayList<>();

     if(source==destination) return true;

     for(int i=0; i<n; i++){
        graph.add(new ArrayList<>());
     }

     for(int[] edge : edges ){
         int x = edge[0];
         int y = edge[1];

         graph.get(x).add(y);
         graph.get(y).add(x);
     }

     Queue<Integer> q = new LinkedList<>();
     boolean[] visited = new boolean[n];

     q.add(source);
     visited[source] = true;
    
     while(!q.isEmpty()){

        int curr = q.poll();

        for(int neigh : graph.get(curr)){
            if(neigh==destination)return true;

            if(!visited[neigh]){
                visited[neigh] = true;
                q.add(neigh);
            }
        }
     }

     return false;

    }
}
// @lc code=end

