class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        
        int cnt = 0;

        boolean[] visit = new boolean[row];

        for(int i=0; i<row ; i++){
            if(!visit[i]){
                cnt++;
                bfs(isConnected , visit , row , i);
            }

        }

        return cnt;

    }

    public void bfs(int[][] grid , boolean[]visit, int n , int node){
      Queue<Integer> q = new LinkedList<>();

      q.add(node);
      visit[node] = true;

      while(!q.isEmpty()){
          int curr = q.poll();

          for( int i=0; i<n; i++){
            if(!visit[i] && grid[curr][i]==1){
                q.add(i);
                visit[i] = true;
            }
          }
      }
    }
}