class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int preIndex = -1, curIndex;
        for(int i = 0; i < s.length(); i++){
            curIndex = t.indexOf( s.charAt(i), preIndex + 1);
            System.out.println(curIndex);
            if(curIndex < 0) return false;
            preIndex = curIndex;
        }
        return true;        
    }
}