class Solution {
//     public int integerBreak(int n) {
        
//         int[] dp = new int[Math.max(7, n + 1)]; 
        
//         if(n <= 3)return n - 1;
//         dp[4] = 4;
//         dp[5] = 6;
//         dp[6] = 9;
        
//         for(int i = 7; i <= n; i++){
//             dp[i] = dp[i - 3] * 3;
//         }
        
//         return dp[n];
        
        // O (1) memory
   public int integerBreak(int n) {

        if(n <= 3)return n - 1;

        int p1 = 4;
        int p2 = 6;
        int p3 = 9;

        for(int i = 7; i <= n; i += 3){
            p1 *= 3;
            p2 *= 3;
            p3 *= 3;
        }

        int mod = n % 3;
        if(mod == 1)return p1;
        if(mod == 2)return p2;
        return p3;            
    }         
}

