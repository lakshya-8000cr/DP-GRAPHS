/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

      int row = grid.length;
      int col = grid[0].length;

      boolean[][] visit = new boolean[row][col];
      int cnt = 0;
      int maxarea = 0;

      for(int i=0; i<row; i++){
        for(int j=0; j<col; j++){
            if(!visit[i][j] && grid[i][j]==1){
                int area = bfs(visit , grid , i , j , row , col , cnt);
                maxarea = Math.max(area , maxarea);
            }
        }
      }

      return maxarea;

    }


    public int bfs(boolean[][] visit , int[][] grid , int stro , int stcol , int row , int col , int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{stro,stcol});

        int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
        };

        visit[stro][stcol]=true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir : dirs){
                int newro = curr[0] + dir[0];
                int newcol = curr[1] + dir[1];

                if(newro>=0 && newro<row && newcol>=0 && newcol < col && grid[newro][newcol]==1 && !visit[newro][newcol]){
                    cnt++;
                    visit[newro][newcol] = true;
                    q.add(new int[]{newro , newcol});
                }
            }
        }

        return cnt+1;
    }
}
// @lc code=end

