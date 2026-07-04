import java.util.*;
public class Solution {

    public static boolean isCycle(int node , boolean[] visit , List<List<Integer>>ls){
        // this will store the current node with their parent node like{currw , parent}
        Queue<int[]> q = new LinkedList<>();
        visit[node] = true; // mark the current node visited true
        q.add(new int[]{node , -1}); // -1 bcz in start we assume that -1 is parent of src

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int nod = curr[0]; // first node is curr , 
            int parent = curr[1]; // second node is parent

            //now we will loop over the neighbours
            for(int neigh : ls.get(nod)){
                if(!visit[neigh]){
                    visit[neigh] = true;
                    q.add(new int[]{neigh , nod}); //add both the parent and current node 
                }

                else if(neigh != parent && visit[neigh]==true){
                    return true;
                }
            }
        }

        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // we will need to initialize the adjancy list from the number of nodes;
        // we will create a list for every node;

        List<List<Integer>> ls = new ArrayList<>();
        
        // we will create the list
        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }

        // populate the elements in the list
        for(int i=0; i<m; i++){
           int v = edges[i][0];
           int u = edges[i][1];

           ls.get(v).add(u);
           ls.get(u).add(v);
        }

        boolean[] visit = new boolean[n + 1];

        // we will loop thru the entire graoh and vertices to hadle the disconnected component
        for(int i=1; i<=n; i++){
             boolean ans = false;
            if(!visit[i]){
               if(isCycle(i,visit,ls)){
                   return "Yes";
               }
            }

            
        }

        return "No";
    }
    
}