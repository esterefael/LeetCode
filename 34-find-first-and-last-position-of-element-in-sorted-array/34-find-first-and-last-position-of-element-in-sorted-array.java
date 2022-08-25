class Solution {
    public int[] searchRange(int[] nums, int target) {
        int last = findLast(nums, target);
        return new int[]{findFirst(nums, target, last), last};        
    }
    public int findLast(int[] nums, int target){
        int l = -1, h = nums.length, m;
        while(l + 1 < h){
            m = l + (h - l) / 2;
            if(nums[m] <= target)
                l = m;
            else
                h = m;
        }
        if(l == -1 || nums[l] != target)
            return -1;
        return l;        
    }    
    public int findFirst(int[] nums, int target, int h){
        int l = -1, m;
        while(l + 1 < h){
            m = l + (h - l) / 2;
            if(nums[m] >= target)
                h = m;
            else
                l = m;
        }
        return h;
    }
}