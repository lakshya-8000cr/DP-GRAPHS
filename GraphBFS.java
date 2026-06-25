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
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int curr = q.poll();

                System.out.println(curr + " ");

                for(int neight : adjList.get(curr)){
                    if(!visited[neight]){
                        q.add(neight);
                        visited[neight] = true;
                    }
                }
            }

            System.out.println();
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
