class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        final int N = strs.length;
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i < N; i++){
            int cntM = count0(strs[i]);
            int cntN = strs[i].length() - cntM;
            for(int j = m; j >= cntM; j--){
                for(int k = n; k >= cntN; k--)
                    memo[j][k] = Math.max(memo[j][k], memo[j - cntM][k - cntN] + 1);
                
            }            
        }
        return memo[m][n];
    } 
    public int count0(String s){
        int res = 0;
        for(char c:s.toCharArray())
            if(c == '0')
                res++;
        return res;
    }
}