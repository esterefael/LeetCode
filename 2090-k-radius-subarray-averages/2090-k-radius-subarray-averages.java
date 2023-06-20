class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if(n <= k * 2)   return res;        
        long sum = 0;
        for(int i = 0; i < 2 * k; i++){
            sum += nums[i];
        }
        for(int i = k; i < n - k; i++){
            sum += nums[i + k];
            res[i] = (int)(sum  / (2 * k + 1));
            sum -= nums[i - k];
        }
        return res;
    }
}