class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = {
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int live = 0;

                for(int[] d : dirs){
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if(ni >= 0 && ni < m && nj >= 0 && nj < n){
                        if(board[ni][nj] == 1 || board[ni][nj] == 2) live++;
                    }
                }

                if(board[i][j] == 1){
                    if(live < 2 || live > 3){
                        board[i][j] = 2;
                    }
                } else {
                    if(live == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
}