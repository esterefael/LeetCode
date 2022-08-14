class Solution {
    
    public boolean makesquare(int[] matchsticks) {
                
        int sum = 0;
        for(int stick:matchsticks)
            sum += stick;
        if(sum % 4 != 0)
            return false;
        int size = sum / 4;
        // Arrays.sort(matchsticks); 
        // Collections.reverse(Arrays.asList(matchsticks));
        // if(matchsticks[0] > size)
        //     return false;
        int cntLargerHalf = 0;
        int half = size / 2;
        for(int stick:matchsticks)
            if(stick > half)
            if(stick > size || ++cntLargerHalf > 4)
                return false; 
    
        int[] group = new int[4];
        return makesquare(matchsticks, group, 0, size);
    }
    public boolean makesquare(int[] matchsticks, int []group, int i, int size) {
        if(i == matchsticks.length)
            // return Arrays.equals(group, new int[]{size, size, size, size});
            return true;
        for(int j = 0; j < 4; j++)
            if(group[j] + matchsticks[i] <= size){
                group[j] += matchsticks[i];
                if(makesquare(matchsticks, group, i + 1, size))
                    return true;
                group[j] -= matchsticks[i];
                if(group[j] == 0)
                    return false;
            }
        return false;        
    }
} 