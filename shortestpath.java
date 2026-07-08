import java.util.*;
public class Solution {

	public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
	    // in this we will use the approach , track all nodes mrk them visit then
		// store their parents
		// then back track the parents ,  i mean if src = 0 , des = 9then we will forst go to ninethen firnd thier parent then usk parent tab tak karege jab tak src  ke equal n h o je
		

		//ans list
		LinkedList<Integer> ans = new LinkedList<>();


		//new list 
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();


		//prepare
		for(int i=0; i<=n; i++){
			ls.add(new ArrayList<>());
		}

		// populate the list
		for(int[] edge : edges){
			int u = edge[0];
			int v = edge[1];

			ls.get(u).add(v);
			ls.get(v).add(u);
		}

		//visited array
		boolean[] visit = new boolean[n+1];

		//parents store
		int[] arr = new int[n+1];

		//bfs logic 
		Queue<Integer> q = new LinkedList<>();
		visit[s] = true;
		q.add(s);
		arr[s] = -1;

		while(!q.isEmpty()){
			int curr = q.poll();

			// traverse the neigh
		    for(int neigh : ls.get(curr)){
				if(!visit[neigh]){
					q.add(neigh);
					visit[neigh] = true;
					arr[neigh] = curr;
				}
			}
		}

		// now we will traverse the arr till we reach the destination
		int curr = t;


        ans.add(curr);
		while(curr != s){
			curr = arr[curr];
			ans.add(curr);
		}

		Collections.reverse(ans);

		return ans;

	}

}