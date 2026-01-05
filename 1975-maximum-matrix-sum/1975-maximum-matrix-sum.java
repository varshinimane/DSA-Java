class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int ncnt = 0;
        int minAbs = Integer.MAX_VALUE;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                int val = matrix[i][j];
                int absval = Math.abs(val);

                totalSum += absval;

                if(val < 0){
                    ncnt++;
                }

                minAbs = Math.min(minAbs, absval);
            }
        }
        if(ncnt % 2 == 1){
            totalSum -= 2L * minAbs;
        }
        return totalSum;
    }
}