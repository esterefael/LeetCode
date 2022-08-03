class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        final int N = nums.length;
        int [][] maxRank = new int[N][N];
        
        for(int i = 0; i < N; i++)
            maxRank[i][i] = nums[i];
        
        for(int len = 1; len < N; len++)
            for(int start = 0; start < N - len; start++)
                maxRank[start][start + len] = Math.max(nums[start] - maxRank[start + 1][start + len], nums[start + len] - maxRank[start][start + len - 1]); 
        return maxRank[0][N - 1] >= 0;               
    }
}