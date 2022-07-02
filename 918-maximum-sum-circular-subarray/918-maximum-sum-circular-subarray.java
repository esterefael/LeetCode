class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int preMin = Integer.MAX_VALUE, min = preMin;
        int preMax = Integer.MIN_VALUE, max = preMax;
        int sum = 0;
        for(int n:nums){
            preMax = Math.max(preMax, 0) + n;
            max = Math.max(preMax, max); 
            preMin = Math.min(preMin, 0) + n;
            min = Math.min(preMin, min);
            sum += n;
        }        
        return max < 0 ? max: Math.max(max, sum - min);
    }
}
