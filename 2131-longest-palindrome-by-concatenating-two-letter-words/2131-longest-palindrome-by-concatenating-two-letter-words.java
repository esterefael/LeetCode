class Solution {
    public int longestPalindrome(String[] words) {
        int[][]cnt = new int[26][26];
        for(String s:words)
            cnt[s.charAt(0) - 'a'][s.charAt(1) - 'a']++;
        int res = 0, hasOdd = 0;
        for(int i = 0; i < 26; i++){
            if(cnt[i][i] % 2 == 1)
                hasOdd = 2;
            res += cnt[i][i] / 2;
            for(int j = i + 1; j < 26; j++)
                res += Math.min(cnt[i][j], cnt[j][i]);
        }               
        return res * 4 + hasOdd;
    }
}