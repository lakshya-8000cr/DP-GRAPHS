class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;

         int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
         };
 
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] curr = q.poll();

                for(int[] dir : dirs){
                    int newro = curr[0] + dir[0];
                    int newco = curr[1] + dir[1];

                    if(newro>=0 && newro < row && newco>=0 && newco<col && image[newro][newco]==original){
                        image[newro][newco] = color;
                        q.add(new int[]{newro , newco});
                    }
                }
            }
        }

        return image;
    }
}