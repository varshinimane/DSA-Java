class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for(int j = 0; j < n; j++){
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, boolean[][] visited, int r, int c){
        int m = heights.length, n = heights[0].length;

        visited[r][c] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(heights, visited, nr, nc);
            }
        }
    }
}