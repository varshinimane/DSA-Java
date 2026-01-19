class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefixSum = new int[m + 1][n + 1];
        for(int i  = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                prefixSum[i][j] = mat[i - 1][j - 1] 
                + prefixSum[i - 1][j] //sum from top
                + prefixSum[i][j - 1] //sum from left
                - prefixSum[i - 1][j - 1]; //remove double covered area
            }
        }
        int max = 0;

        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                int next = max + 1;
                //square between matrix bounds
                if(i >= next && j >= next){
                    //sum of square ending at (i,j)
                    int sum = prefixSum[i][j] 
                    - prefixSum[i - next][j] 
                    - prefixSum[i][j - next] 
                    + prefixSum[i - next][j - next];

                    if(sum <= threshold) {
                        max = next;
                    }
                }
            }
        }
        return max;
    }
}