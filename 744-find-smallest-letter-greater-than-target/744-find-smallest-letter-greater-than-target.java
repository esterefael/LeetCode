class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = -1, h = letters.length, m;
        while(l + 1 < h){
            m = l +(h - l) / 2;
            if(letters[m] > target)
                h = m;
            else
                l = m;                
        }
        return letters[h % letters.length];
    }
}