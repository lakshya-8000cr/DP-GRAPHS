import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // we will solve this question using the bfs , not dfs bcz 
        //prepare the list
        //bfs = we will count the indegrree, then if we remove the element then we will decrease the indegre of its neighbour element
        //then if(indegree==0)then push in queue , then normal bfs logic then, the just push the element in queue after poping
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

        for(int i=0; i<v; i++){
            ls.add(new ArrayList<>());
        }

        //indegree 
        int[] indegree = new int[v+1];

        //populate the list
        for(int i=0; i<e; i++){
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);

            ls.get(a).add(b);
            // now indegree ++ for the a bcz uski taraf list point hori hai
            indegree[b]++;
        }

        // make a queue
        Queue<Integer> q = new LinkedList<>();
        
        //push all the element which have zero indegree in queue
        for(int i=0; i<v; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //list ans
        ArrayList<Integer> l = new ArrayList<>();

        // now we will apply the normal bfs logic
        while(!q.isEmpty()){
            // pop the element as of normal logic
            int curr = q.poll();
            // now save this element to the list
            l.add(curr);

            // now trverse the neighbour
            for(int neigh : ls.get(curr)){

                indegree[neigh]--;

                if(indegree[neigh] == 0){
                    q.add(neigh);
                }

                // now we will decrease the indegree of the neigbour which are associated with the curr node
            }
        }

        return l;

    }
}