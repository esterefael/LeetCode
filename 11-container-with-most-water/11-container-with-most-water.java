class Solution {
    public int maxArea(int[] height) {
        
        final int N = height.length;
        int max = 0;
        int left = 0;
        int right = N -1;
        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }        
        return max;
    }
}