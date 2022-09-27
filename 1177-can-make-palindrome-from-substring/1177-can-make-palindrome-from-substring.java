class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new LinkedList<>();
        int[]cnt = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++)
            cnt[i + 1] = cnt[i] ^ (1 << (s.charAt(i) - 'a'));
        for(int[]q:queries)
            res.add(q[2] >= Integer.bitCount(cnt[q[1] + 1] ^ cnt[q[0]]) / 2);
        return res;
    }
}