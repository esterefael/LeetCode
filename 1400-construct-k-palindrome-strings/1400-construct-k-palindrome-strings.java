class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length())
            return false;
        int[]cnt = new int[26];
        for(char c:s.toCharArray())
            cnt[c - 'a']++;
        int cntOdd = 0;
        for(int n:cnt)
            if(n % 2 == 1)
                cntOdd++;
        return cntOdd <= k;
    }
}