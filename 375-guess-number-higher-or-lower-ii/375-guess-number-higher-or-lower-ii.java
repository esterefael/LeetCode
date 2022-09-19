class Solution {
    public int getMoneyAmount(int n) {        
        int[][] dp = new int[n + 1][n + 1];
        for(int len = 1; len <= n - 1; len++) 
            for(int start = 1; start <= n - len; start++){
                int end = start + len;
                dp[start][end] = Integer.MAX_VALUE;
                for(int cur = start; cur < end; cur++)
                    dp[start][end] = Math.min(dp[start][end], cur + Math.max(dp[start][cur - 1], dp[cur + 1][end]));
            }        
        return dp[1][n];
    }
}