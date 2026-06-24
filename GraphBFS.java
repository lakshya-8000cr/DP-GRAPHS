import java.util.*;

public class GraphBFS {
    
    private Map<Integer, List<Integer>> adjList;
    
    public GraphBFS() {
        adjList = new HashMap<>();
    }
    
    public void addVertex(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }
    
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    


    public void bfs(int start) {
        boolean[] visited = new boolean[5];
        Queue<Integer> q  = new LinkedList<>();

        visited[start] = true;

        q.add(start);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int curr = q.poll();  // curr level ke nodes

                System.out.println(curr + " ") ; // curr level ke nodes print krooo 

                // now we will find the neighbour of the curr level i mean edges

                for(int neighbour : adjList.get(curr) ) { // all the edges connected to the current level node
                    if(!visited[neighbour]){  // if the neighbour are not visited then add the neighbour in queue
                        q.add(neighbour);
                        visited[neighbour] = true;  // mrked true
                    }
                }
                
            }
            System.out.println(); // our level 1 ends here suoooo
        }
    }
    

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS();
        
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        
        g.bfs(1);
        
        // Expected Output:
        // 1
        // 2 3
        // 4
    }
}
