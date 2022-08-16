class Solution {
    public int firstUniqChar(String s) {
        short[] countChars = new short[26];
        for(int i = 0; i < s.length(); i++)
            countChars[s.charAt(i) - 'a']++;
        for(int i = 0; i < s.length(); i++)
            if(countChars[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}