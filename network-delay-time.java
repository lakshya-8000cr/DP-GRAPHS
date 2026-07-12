/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // we will use our jkstra approach
        // prepare the adj list
        //populate it 
        //then find the shortest 
        //list

        ArrayList<ArrayList<int[]>> ls = new ArrayList<>();
        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }   

        //populate the list
        for(int[] edge : times){
            int u = edge[0]; // first one will be the u
            int v = edge[1]; // second one v
            int w = edge[2]; // this represent the weight

            ls.get(u).add(new int[]{v,w}); // this is directed graph so only u to v;
        }

        //prepare for the jkstra ,1-> priority queue , 2-> dist arr
        //we can assume that source to soucr dist = 0, now we will push this pair to the queue(new int[]{0,source});
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        int[] dist = new int[n+1]; //done both

        // fill the dist with Integer.MAX_VALUE
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k] = 0; // bro u just forget this condition this was important main
        
        //our source condition 
        pq.add(new int[]{0,k}) ; //assuming k to k = 0

        //bfs
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int currd = top[0];
            int node = top[1]; // {0,k} 0==currdistance , k==node for first iteration

            if(currd > dist[node]){
                continue; // neglect if the value is path is greater;
            }

            // now iterate thru the neighbours to track'

            for(int[] neigh : ls.get(node)){ // simple bcz our neighbour have its own list node is connected to ne
                int nextNode = neigh[0]; // first element of list is node , 
                int dis = neigh[1]; // second element is our distance ( you may confuse this indexing with the queue)

                if(dis + dist[node] < dist[nextNode]){
                    dist[nextNode] = dis + dist[node] ; // we are updation the array if short path is there
                    pq.add(new int[]{dist[nextNode] , nextNode});
                }
            }    
        
        }

        int max = -1;

        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            else if(dist[i] > max){
                max = dist[i];
            }
        }
        return max;
    }
}
// @lc code=end

