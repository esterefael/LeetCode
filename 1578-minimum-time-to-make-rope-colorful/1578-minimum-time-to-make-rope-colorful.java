class Solution {
    public int minCost(String colors, int[] neededTime) {
        int max = neededTime[0], res = neededTime[0];
        for(int i = 1; i < colors.length(); i++){
            if(colors.charAt(i) != colors.charAt(i - 1)){
                res -= max;
                max = neededTime[i];
            }
            res += neededTime[i];
            max = Math.max(max, neededTime[i]);                
        }
        return res - max;
    }
}