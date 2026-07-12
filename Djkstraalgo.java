import java.util.* ;
import java.io.*; 
public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		// the approach we will use in this question is jkstra algorithm to find the shortest path
		// all the structure we will need , 1->Priority queue , 2-> distance array 
		// we will use the bfs approach , then after finding the shortest distance then put in dist array

		//prepare a adjancy list
		ArrayList<ArrayList<int[]>> ls = new ArrayList<>();

		for(int i=0; i<vertices; i++){
			ls.add(new ArrayList<>());
		} 

		//populate the list
		//undirected , 3 indexes -> 1(u) , 2(v) , 3(w)(the weight)';'
		for(int i=0; i<edges; i++){
			int u = vec.get(i).get(0); // the first;
			int v = vec.get(i).get(1); // second
			int w = vec.get(i).get(2); // the weight

            ls.get(u).add(new int[]{v,w}); // we have the array inside our second list which will contain the the node with weight
			ls.get(v).add(new int[]{u,w}); // undirected app

		}

		//now lets make the ds 1-> dist array , 2->priority queue
		int[] dist = new int[vertices];


		//fill the dist with the Integer.MAX_VALUE
		Arrays.fill(dist , Integer.MAX_VALUE);

		//make the priorith queue ( to get the top element)also we have setup the paired inside theq which will contain the (weight , node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		//distance of source to source is 0 assume
		dist[source] = 0;

		//push the source inside the q wiht dist
		pq.add(new int[]{0,source});


		//bfs logic
		while(!pq.isEmpty()){
			int[] top = pq.poll();

			int d = top[0];
			int node = top[1];

			if(d > dist[node]){
				continue;
			}

			// lets iterate thru the neighbours
			for(int[] neigh : ls.get(node)){
				int weight = neigh[1];
				int nextNode = neigh[0];

                // main logic takes place here , so dont mistake here 
				if(weight + dist[node] < dist[nextNode]){
					dist[nextNode] = weight + dist[node];
					pq.add(new int[]{dist[nextNode] , nextNode});
				}
			}
		}

	   ArrayList<Integer> l = new ArrayList<>();
	   for(int x : dist){
		   l.add(x);
	   } 	

       return l;

	}
}