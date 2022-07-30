class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int N = s1.length();
        if(N > s2.length())return false;
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        
        for(int i = 0; i< N ;i++){
            counter1[s1.charAt(i) - 'a']++;
            counter2[s2.charAt(i) - 'a']++;
        }
        
        int l = 0;
        int r = N;
        while(r < s2.length()){
            if(Arrays.equals(counter1, counter2))//constant time the arrays size is 26
                return true;
            counter2[s2.charAt(l++) - 'a']--;
            counter2[s2.charAt(r++) - 'a']++;
        }
        return Arrays.equals(counter1, counter2);
    }
}
