class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        final int N = s.length();
        int[] res = new int[queries.length];
        int[] cnt = new int[N];
        int[] pre = new int[N];
        int[] next = new int[N];
        int preCandles = -1;
        int countPlates = 0;
        for(int i = 0; i < N; i++){
            if(s.charAt(i) == '*')
                countPlates++;        
            else{
                for(int j = preCandles + 1; j <= i; j++)
                    next[j] = i;
                preCandles = i;
            }   
            pre[i] = preCandles; 
            cnt[i] = countPlates;
        }
        for(int i = preCandles + 1; i < N; i++)
            next[i] = -1;
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0], right = queries[i][1];
            int startLeft = next[left], endRight = pre[right];
            res[i] = (startLeft == -1 || endRight == - 1 || startLeft >= endRight) ? 0 : cnt[endRight] - cnt[startLeft];
        }
        return res;
    }
}