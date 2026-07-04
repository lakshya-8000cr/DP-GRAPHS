import java.util.*;
public class Solution {

  public static boolean dfs(int node , boolean[] visit , List<List<Integer>> ls ,boolean[] dfsVisited){

    visit[node] = true;
    dfsVisited[node] = true; // you have to mark this univisted in end

    //now iterate thru the neighbours;

    // there is one diff condition , cond is if visit i true and dfsVisited also true then cycle present 
    // , diff from undirected in which if visit but parent!=node then cycle 

    for(int neigh : ls.get(node)){
       if(!visit[neigh]){
         boolean ans = dfs(neigh , visit , ls ,dfsVisited);
         if(ans)return true;
       }

       else if(visit[neigh] == true && dfsVisited[neigh]==true){ // the condition i abt talked above 
         return true;
       }
    }

    dfsVisited[node] = false; // imp catch 
    return false;

  }

  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
    //fisrt prepare the adjncy list
    List<List<Integer>> ls = new ArrayList<>();

    // now loop thru the nodes , per node one list

    for(int i=0; i<=n; i++){
      ls.add(new ArrayList<>());
    }

    // now we will populate the list thru elements
    int siz = edges.size();
    for(int i=0; i<siz; i++){
        int a = edges.get(i).get(0);
        int b = edges.get(i).get(1);

        ls.get(a).add(b); // ony a to be bcz directed graph
    }

    // now make a visited array 
    boolean[] visit = new boolean[n+1];

    //now make the dfsVisited 
    boolean[] dfsVisited = new boolean[n+1];

    //now handle the disconnected comp
    for(int i=1; i<=n; i++){
      if(!visit[i]){
        if(dfs(i , visit , ls ,dfsVisited )){
          return true;
        }
      }
    }

    return false;
  }
}