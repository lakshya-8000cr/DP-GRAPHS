import java.util.*;

public class BellmanFordPractice {



    public static int[] bellmanFord(int n, int[][] edges, int src) {
        int[] dis = new int[n];
        Arrays.fill(dis , Integer.MAX_VALUE);
        dis[src] = 0;

        for(int i=0; i<n-1; i++){
            boolean update = false;
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if(dis[u]!=Integer.MAX_VALUE && w + dis[u] < dis[v]){
                    dis[v] = dis[u] + w;
                    update = true;
                }
            }

            if(!update)break;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(dis[u]!=Integer.MAX_VALUE && w + dis[u] < dis[v]){
                return null;
            }
        }

        return dis;
    }


    // public static int bellmanFordWithKEdges(int n, int[][] edges, int src, int dst, int k) {

    // }

    // ---------- Test Harness ----------
    public static void main(String[] args) {
        // Test 1: normal graph, no negative cycle
        int n1 = 4;
        int[][] edges1 = {
            {0, 1, 4},
            {0, 2, 5},
            {1, 2, -3},
            {2, 3, 2},
            {1, 3, 6}
        };
        int[] result1 = bellmanFord(n1, edges1, 0);
        System.out.println("Test 1 (expected [0,4,1,3]): " + Arrays.toString(result1));

        // Test 2: graph with a negative cycle
        int n2 = 3;
        int[][] edges2 = {
            {0, 1, 1},
            {1, 2, -1},
            {2, 0, -1}   // cycle 0->1->2->0 has weight 1-1-1 = -1 (negative cycle)
        };
        int[] result2 = bellmanFord(n2, edges2, 0);
        System.out.println("Test 2 (expected null): " + (result2 == null ? "null" : Arrays.toString(result2)));

        // Test 3: disconnected node
        int n3 = 5;
        int[][] edges3 = {
            {0, 1, 2},
            {1, 2, 3}
            // node 3, 4 disconnected
        };
        int[] result3 = bellmanFord(n3, edges3, 0);
        System.out.println("Test 3 (node 3,4 should be MAX_VALUE): " + Arrays.toString(result3));

        // Test 4: k-edges constrained version (Cheapest Flights style)
        int n4 = 3;
        int[][] edges4 = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500}
        };
        // int ans4 = bellmanFordWithKEdges(n4, edges4, 0, 2, 1); // expect 200
        // System.out.println("Test 4 (expected 200): " + ans4);
    }
}