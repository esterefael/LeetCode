class Solution {
    public String getHint(String secret, String guess) {
        int[]cnt = new int[10];
        int a = 0, b = 0;
        for(int i = 0; i < guess.length(); i++){
            int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
            if(s == g)
                a++;
            else{
                if(cnt[s] < 0)b++;
                if(cnt[g] > 0)b++; 
                cnt[s]++;
                cnt[g]--;
            }
        }        
        return a + "A" + b + "B";    
    }
}
