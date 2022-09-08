class Solution {
    public int findMin(int[] nums) {
        int l = -1, h = nums.length - 1, m;
        while(l + 1 < h){
            m = l + (h - l) / 2;
            if(nums[m] < nums[nums.length - 1])
                h = m;
            else
                l = m;
        }
        return nums[h];
    }
}