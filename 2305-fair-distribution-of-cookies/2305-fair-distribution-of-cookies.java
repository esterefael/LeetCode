class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        
        distributeCookies(cookies, k, 0, new int[k]);
        return res;
    }
    public void distributeCookies(int[] cookies, int k, int start,int[] devision) {
        if(start == cookies.length){
            
            res = Math.min(res, Arrays.stream(devision).max().getAsInt());
            return;
        }
        
        for(int i = 0; i < k; i++){
            
            devision[i] += cookies[start];
            // if(devision[i] <= res)
                distributeCookies(cookies, k, start + 1, devision);
            devision[i] -= cookies[start];
            if(devision[i] == 0)break;
        }
    }
}


