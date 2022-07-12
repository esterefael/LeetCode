class Solution {
    public int integerBreak(int n) {
        
        int[] dp = new int[Math.max(7, n + 1)]; 
        
        if(n <= 3)return n - 1;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        
        for(int i = 7; i <= n; i++){
            dp[i] = dp[i - 3] * 3;
        }
        
        return dp[n];
            
    }
}
