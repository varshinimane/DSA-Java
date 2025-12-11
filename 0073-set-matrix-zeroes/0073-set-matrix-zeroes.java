class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;


        //check if first row has a zero
        for(int j = 0;j < n;j++){
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        
        //check if first col has a zero
        for(int i = 0;i < m;i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }

        //using first row and first col as markers to find other zeroes
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //zero out based on markers
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //zero out first row if needed
        if(firstRow){
            for(int j = 0;j < n;j++){
                matrix[0][j] = 0;
            }
        }

        //zero out first col if needed
        if(firstCol){
            for(int i = 0;i < m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}