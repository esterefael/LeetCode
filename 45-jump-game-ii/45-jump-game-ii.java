class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int cnt = 0 ;
        int max =  0 ;
        int maxIndex = 0 ; 
        
        for(int i = 0 ; i < n - 1 && maxIndex < n; i++){
            max = Math.max(max , i+nums[i]);
            if(i==maxIndex){
                cnt++ ;
                maxIndex = max ;
               }
        }
        
        return cnt ;
    }
    
}

