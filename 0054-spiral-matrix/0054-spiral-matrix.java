class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //Edge Cases
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null){
            return result;
        }

        int m = matrix.length; //number of rows
        int n = matrix[0].length; //number of columns 

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while(top <= bottom && left <= right){
            for(int c = left;c <= right;c++){ 
                result.add(matrix[top][c]); //row is const and columns are changing 
            }
            top++;

            for(int r = top;r <= bottom;r++){
                result.add(matrix[r][right]); //column is const and row is changing
            }
            right--;

            if(top <= bottom){
                for(int c = right;c >= left;c--){
                    result.add(matrix[bottom][c]); //row is const
                }
                bottom--;
            }

            if(left <= right){
                for(int r = bottom;r >= top;r--){
                    result.add(matrix[r][left]); //column is const
                }
                left++;
            }
        }
        return result;
    }
}