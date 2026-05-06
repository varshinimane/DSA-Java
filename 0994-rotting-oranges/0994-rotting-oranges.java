class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int minutes = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for(int i = 0;i < size;i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for(int[] d : dirs){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if(rotted) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}