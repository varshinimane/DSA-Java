class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int[][] result = new int[total][2];
        int idx = 0;
        result[idx++] = new int[]{rStart,cStart};
        int step = 1;
        int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};
        int r = rStart,c = cStart;
        while(idx < total){
            for(int i  = 0;i < 4 && idx < total;i++){
                int dr = dirs[i][0], dc = dirs[i][1];
                for(int s = 0;s < step && idx < total;s++){
                    r += dr;
                    c += dc;
                    if(0 <= r && r < rows && 0 <= c && c < cols){
                        result[idx++] = new int[]{r,c};
                    }
                }
                if(i % 2 == 1) step++;
            }
        }
        return result;
    }
}