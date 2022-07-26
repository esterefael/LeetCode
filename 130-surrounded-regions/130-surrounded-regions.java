class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    public void solve(char[][] board) {
        
        final int R = board.length;
        final int C = board[0].length;
        
        char [][] mat = new char[R][C];
        for(char[] arr:mat)
            Arrays.fill(arr, 'X');
        
        for(int i = 0; i < R; i++){
            dfs(board, mat, R, C, i, 0);
            dfs(board, mat, R, C, i, C - 1);
        }  
        for(int i = 0; i < C; i++){
            dfs(board, mat, R, C, 0, i);
            dfs(board, mat, R, C, R - 1, i);
        }
        for(int i = 0; i < R; i++)       {
            board[i] = Arrays.copyOf(mat[i],C);
        }
    }
    
    public void dfs(char[][] board, char[][] mat, int R, int C, int i, int j ){
        
        if(i < 0 || i == R || j < 0 || j == C || mat[i][j] == 'O' || board[i][j] == 'X')
            return;
        mat[i][j] = 'O';
        for(int[] d:dir)
            dfs(board, mat, R, C, i + d[0], j + d[1]);        
    }
}