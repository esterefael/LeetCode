class Solution {
    public boolean divisorGame(int n) {
        
//         boolean[] isWin = new boolean[n + 1];
//         for(int i = 2; i <= n; i++)            
//             for(int j = 1; j <= Math.sqrt(i); j++)                
//                 if(i % j == 0 && !isWin[i - j]){
                    
//                     isWin[i] = true;
//                     break;
//                 }    
//         return isWin[n];
        return n % 2 == 0;
    }
}