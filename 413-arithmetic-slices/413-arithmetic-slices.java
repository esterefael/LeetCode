class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        final int N = nums.length;
        int[]dp = new int[N];
        int sum = 0;
        
        for(int i = 2; i < N; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;// All the options from the previos element + 1 option with length 2.
            }
            sum += dp[i];
        }
        return sum;
    }
}