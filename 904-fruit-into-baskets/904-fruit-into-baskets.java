class Solution {
    public int totalFruit(int[] fruits) {
        
        final int N = fruits.length;        
        int endType1 = findNextType(fruits, 0);
        int cnt = endType1 + 1, max = 1;
        
        while(endType1 + 1 < N){
            
            int endType2 = findNextType(fruits,endType1 + 1); 
            cnt += endType2 - endType1;
            if(endType2 + 1 < N && fruits[endType2 + 1] != fruits[endType1]){
                max = Math.max(max, cnt);
                cnt = endType2 - endType1;                
            }        
            endType1 = endType2;    
        }
        return Math.max(max, cnt);
    }
    
    public int findNextType(int[] fruits, int i){
        final int N = fruits.length;
        int type = fruits[i];
        while(++i < N && fruits[i] == type);
        return i - 1;// return the last i which follows the above conditions.
    }
}