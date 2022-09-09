class Solution {
    public int arrangeCoins(int n) {
        long l = 1, h = n, m;
        while(l + 1 < h){
            m = l + (h - l) / 2;
            if(n >= (1 + m) * m / 2)
                l = m;
            else
                h = m;
        }
        return (int)l;
    }
}