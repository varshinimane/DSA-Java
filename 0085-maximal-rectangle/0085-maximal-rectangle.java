class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] mat = new int[rows][cols];

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        for(int i = 0;i < rows;i++){
            for(int j = 1;j < cols;j++){
                if(mat[i][j] == 1){
                    mat[i][j] += mat[i][j - 1];
                }
            }
        }
        int ans = 0;

        for(int j = 0;j < cols;j++){
            for(int i = 0;i < rows;i++){
                int width = mat[i][j];
                if(width == 0) continue;

                int curr = width;
                for(int k = i;k < rows && mat[k][j] > 0;k++){
                    curr = Math.min(curr, mat[k][j]);
                    int height = k - i + 1;
                    ans = Math.max(ans, curr * height);
                }

                curr = width;
                for(int k = i;k >= 0 && mat[k][j] > 0;k--){
                    curr = Math.min(curr, mat[k][j]);
                    int height = i - k + 1;
                    ans = Math.max(ans, curr * height);
                }
            }
        }
        return ans;
    }
}