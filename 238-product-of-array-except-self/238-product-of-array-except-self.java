class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int N = nums.length;
        int [] res = new int[N];
        
        res[N - 1] = nums[N - 1];
        for(int i = N - 2; i > 0;i--)
            res[i] = res[i + 1] * nums[i];
        
        int temp = 1;
        for(int i = 0; i < N - 1; i++){
            res[i] = res[i + 1] * temp;
            temp *= nums[i];
        }
        res[N - 1] = temp;
        return res;
            
    }
}