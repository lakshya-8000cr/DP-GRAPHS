class Solution {
    public int orangesRotting(int[][] grid) {
        int row  = grid.length;
        int col = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>(); // this will containll the rotten oranges

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        } 

        if(fresh==0)return 0;
        int minute = 0;

        while(!q.isEmpty()){
            minute++;
            int[][] dirs ={
                {-1,0},
                {1,0},
                {0,-1},
                {0,1},
            };

            int size = q.size();

            for(int i=0; i<size; i++){

                 int[] curr = q.poll();

            for(int[] dir : dirs){
                int newro = curr[0] + dir[0];
                int newco = curr[1] + dir[1];

                if(newro >=0 && newro < row && newco >= 0 && newco < col && grid[newro][newco]==1){
                    fresh--;
                    grid[newro][newco] = 2;
                    q.add(new int[]{newro , newco});
                }
            }

           }
        }

        if(fresh==0){
            return minute-1;
        }
        return -1;
    }
}