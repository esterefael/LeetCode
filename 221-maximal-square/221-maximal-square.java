class Solution {
    public int maximalSquare(char[][] matrix) {
        
        final int N = matrix.length + 1;
        final int M = matrix[0].length + 1;
        int [][] dp = new int[N][M];
        int max = 0;
        
        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
        }
    }
