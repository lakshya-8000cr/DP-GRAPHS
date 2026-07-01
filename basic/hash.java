class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;

        int m = grid[0].length;

                if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }

        if(n==1)return 1;
      
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];

        q.add(new int[]{0,0,1});
        visit[0][0] = true;

        int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
            {1,1},
            {1,-1},
            {-1,1},
            {-1,-1},
        };

        
        while(!q.isEmpty()){
             int[] curr = q.poll();

             for(int[] dir : dirs){ 
             int currRo = curr[0] + dir[0];
             int currCol = curr[1] + dir[1];
             int currD = curr[2];

             if(currRo==n-1 && currCol==n-1){
                return currD+1;
             }

             if(currRo>=0 && currRo<n && currCol>=0 && currCol<n && !visit[currRo][currCol] && grid[currRo][currCol]==0){
                q.add(new int[]{currRo,currCol , currD + 1});
                visit[currRo][currCol] = true;
             }
             }
        }

        return -1;

    }
}
