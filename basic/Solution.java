package basic;

import java.util.*;
public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){

       List<Integer> ls = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       boolean[] visit = new boolean[n];

       q.add(0);
       visit[0] = true;

       while(!q.isEmpty()){
           int curr = q.poll();
           ls.add(curr);

           for(int neigh : adj.get(curr)){ // this is for the list
               if(!visit[neigh]){
                   q.add(neigh);
                   visit[neigh] = true;
               }
           }

        //    int[][] dirs = {  this example is just the showcase of hwo the above func works in matrix graph
        //        {-1,0},
        //        {1,0},
        //        {0,-1},
        //        {0,1},
        //    };

        //    for(int[] dir : dirs){
        //        int newro = currro[0] + dir[0];
        //        int newcol = currco[1] + dir[1];

        //        if(newro>=0 && newro<r && newco>=0 && newco<c && matrix[newro][newco]==1 && !visit[newro][newco]){
        //           q.add(new int[]{newro , newcol});
        //           visit[newro][newcol] = true;
        //        }
        //    }
       }

       return ls;

    }
}