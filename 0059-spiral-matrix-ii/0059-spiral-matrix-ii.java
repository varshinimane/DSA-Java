class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int curr = 1;
        int max = n * n;

        while(curr <= max){
            for(int col = left;col <= right && curr <= max;col++){
                result[top][col] = curr++;
            }
            top++;
            
            for(int row = top;row <= bottom && curr <= max;row++){
                result[row][right] = curr++;
            }
            right--;

            for(int col = right;col >= left && curr <= max;col--){
                result[bottom][col] = curr++;
            }
            bottom--;

            for(int row = bottom;row >= top && curr <= max;row--){
                result[row][left] = curr++;
            }
            left++;
        }
        return result;
    }
}