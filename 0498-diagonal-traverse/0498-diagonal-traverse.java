class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] res = new int[m*n];

        List<List<Integer>> diag= new ArrayList<>();

        for(int i = 0;i < m + n - 1;i++){
            diag.add(new ArrayList<>());
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j< n;j++){
                diag.get(i+j).add(mat[i][j]);
            }
        }
        int idx = 0;
        for(int d = 0;d < diag.size();d++){
            if(d % 2 == 0){
                 Collections.reverse(diag.get(d));
            }
            for(int val : diag.get(d)){
                res[idx++] = val;
            }
        }
        return res;
    }
}