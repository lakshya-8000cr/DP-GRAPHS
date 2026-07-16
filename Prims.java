import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // the approach we will use is prims algo
        // our approach will be make 3 data structures 
        // 1-> dist arry ,2-> visited for the mst , 3->parent node the everynode, 
        // step1-> store the source node weight in the dist arry ,
        // step2-> mark the visited array true of the node ,
        // step3-> for the start we are assuming that , the current node have no parent so mark it  -1  ,
        // now get the adjacents and the neighbours of the current node , mark them visited , 
        // conditions -> the node we are visiting should have the visited array false , the weight should be lower than the weght in the key
        // if we find the minimum value in the key node , then just push the new weight in the dist array
        // after updating all the values and marking their parent in the parent node
        // in the end if we need to return the weight then just return sum of the the disrt arry 
        // but if we need the return the minimum spanning tree , then method is different
        // lets start

        //prepare the list
        ArrayList<ArrayList<int[]>> ls = new ArrayList<>();

        int[] key = new int[n+1];
        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1]; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]); // for the min heap

        //now all the structeres are ready

        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }

        //populate the list
        for(int i=0 ; i<m; i++){
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int w = g.get(i).get(2);

            //undirected graph
            ls.get(u).add(new int[]{v,w});
            ls.get(v).add(new int[]{u,w});
        }

        //now lets do our algorithm
        // bfs logic

        Arrays.fill(key , Integer.MAX_VALUE);

        key[1] = 0; // at start we are thinking the distance is 0
        Arrays.fill(parent , -1) ;// suppose there is no parent of the node 0
        //lets do the bfs with the priority queuqe
        pq.add(new int[]{0,1}); // weight , node

        while(!pq.isEmpty()){
            int[] top = pq.poll(); //arr , first index will contain the weight ; second will contain the node
            int currd = top[0];
            int node = top[1];

            //in the current index
            if (visited[node]) continue;
            visited[node] = true;

            // traverse all the neighbours
            for(int[] neigh : ls.get(node)){
                int weight = neigh[1];
                int nextNode = neigh[0];

                if(!visited[nextNode] && weight < key[nextNode]){ //  this is the condition which we need to be carefull about 
                    // visited[nextNode] = true;
                    key[nextNode] =  weight;
                    parent[nextNode] = node;
                    pq.add(new int[]{key[nextNode] , nextNode});
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (parent[i] != -1) {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(parent[i]);
                edge.add(i);
                edge.add(key[i]);
                ans.add(edge);
            }
        }

        return ans;
    }
}
