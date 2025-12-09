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
            for(int i = left;i <= right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i = top;i <= bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right;i >= left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom;i >= top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}