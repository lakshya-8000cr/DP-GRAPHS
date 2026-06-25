import java.util.*;

public class NumberOfIslands {

    void bfs(char[][] grid, boolean[][] visited,
             int startRow, int startCol, int rows, int cols) {
            
            int[][] dirs = {
                {-1,0} , // for the upepr;
                {1,0} , // for the lower
                {0,-1} , // for the left
                {0,1} , // for the right
            };

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startRow , startCol});
            visited[startRow][startCol] = true;

            while(!q.isEmpty()){
                int curr[] = q.poll();
                int currRow = curr[0];
                int currCol = curr[1];


                for(int dir[] : dirs){
                    int newRow = currRow + dir[0];
                    int newCol = currCol + dir[1];

                    if(!visited[newRow][newCol] && newRow>=0 && newRow < rows && newCol>=0 && newCol < cols && grid[newCol][newRow]=='1'){
                      visited[newRow][newCol] = true;
                    }
                }
            }
        
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    bfs(grid, visited, i, j, rows, cols);
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0'},
            {'1', '0', '0'},
            {'0', '1', '1'}
        };
        System.out.println(sol.numIslands(grid));
        // Expected Output: 2
    }
}