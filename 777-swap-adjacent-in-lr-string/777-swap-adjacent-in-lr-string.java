class Solution {
    public boolean canTransform(String start, String end) {
        
        final int N = start.length();        
        int cntL = 0, cntR = 0, lastR = N;
        for(int i = 0; i < N; i++){
            
            char cStart = start.charAt(i);           
            char cEnd = end.charAt(i);
            
            if(cStart == cEnd){
                if(cStart == 'X')
                    continue;
                if(cStart == 'L' && cntR != 0)
                    return false;
                if(cStart == 'R' && cntL != 0)
                    return false;
            }           
            if(cStart == 'L'){
                cntL++;
            }
            if(cStart == 'R'){
                cntR++;
                lastR = i;
            }
            if(cEnd == 'L'){
                if(i >= lastR)
                    return false;                
                cntL--;
            }
            if(cEnd == 'R'){
                cntR--;
                if(cntR == 0)
                    lastR = N;
            }
            if(cntL > 0 || cntR < 0)
                return false; 
        }
        return cntL == 0 && cntR == 0;
    }
    
}
