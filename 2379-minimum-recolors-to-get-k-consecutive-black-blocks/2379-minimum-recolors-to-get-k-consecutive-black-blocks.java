class Solution {
    public int minimumRecolors(String blocks, int k) {
        int s = 0, e, cntW = 0, res;
        for(e = 0; e < k; e++)
            if(blocks.charAt(e) == 'W')
                cntW++;
        res = cntW;
        while(e < blocks.length()){
            if(blocks.charAt(s++) == 'W')
                cntW--;
            if(blocks.charAt(e++) == 'W')
                cntW++;
            res = Math.min(res, cntW);
        }
        return res;
    }
}