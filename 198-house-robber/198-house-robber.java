class Solution {
    
//More readable and fast
    public int rob(int[] nums) {        
    int n=nums.length;
    if(n == 1) return nums[0];
   
    int [] dp = new int[n];
    dp[n - 1]=nums[n - 1];
    dp[n - 2]=Math.max(dp[n - 1], nums[n - 2]);
    for(int i = n-3; i >= 0; i--)
        dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
    return dp[0];
    }
    

//Less memory    
//     public int rob(int[] nums) {        
//     int n = nums.length;
//     if(n == 1) return nums[0];
        
//     int nextNext = nums[--n];
//     int next = Math.max(nextNext, nums[--n]);
//     int cur = next;
//     while(n > 0){
//         System.out.println(next);
//         cur = Math.max(next, nextNext + nums[--n]);
//         nextNext = next;
//         next = cur;                
//     }
//     return cur;
//     }
}