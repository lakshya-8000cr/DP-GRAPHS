/*
 * @lc app=leetcode id=1631 lang=java
 *
 * [1631] Path With Minimum Effort
 */

// @lc code=start
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        //in this question everything will be same , one dif will be the way of accessiong the list or matrix;
        // we will not prepare the adjancy list in this instead we will traverse thru the matrix and for neight we will traverse thru the directions matrix;

        int[][] dirs = {
            {0,1}, // this is how we will traverse the neighbour inside the bfs
            {0,-1},
            {1,0},
            {-1,0},
        };

        // dist array same
        int[][] dist = new int[r][c];

        //fill the array wiht max
        for(int[] n : dist){
            Arrays.fill(n , Integer.MAX_VALUE);
        }
        
        //have array inside the arrayfor storing the indexes
        dist[0][0] = 0;

        //priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0] ); //  min heap
        // in case of list we push the distance with source node ,in this case source node is {0,0} , dist is value at 0,0
        pq.add(new int[]{0 , 0 , 0}); // 0th index represnt the value at the source , 1st index represent the row , 2nd index represent the column

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int currd = top[0];
            int currrow = top[1];
            int currcol = top[2];

            if(currd > dist[currrow][currcol]){
                continue; 
            }

            //we willl traverse the neighbours
            for(int[] dir : dirs){
                int newro = dir[0] + currrow; //updating the row to travers
                int newcol = dir[1] + currcol; // same wiht col
if (newro < 0 || newro >= r || newcol < 0 || newcol >= c) continue;

                int diss = Math.abs(heights[newro][newcol] - heights[currrow][currcol]);

                // path ka naya effort = max(purana path effort, is step ka effort)
                int newEffort = Math.max(dist[currrow][currcol], diss);

                if (newEffort < dist[newro][newcol]) {
                    dist[newro][newcol] = newEffort;
                    pq.add(new int[]{newEffort, newro, newcol});
                }

            }
        }

        return dist[r-1][c-1];

    }
}
// @lc code=end

