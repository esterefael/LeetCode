class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        final int N = arr.length;
        long[] dp  = new long[N]; 
        Arrays.fill(dp, 1);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++)
            map.put(arr[i], i);
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i ; j++){
                if(arr[i] % arr[j] == 0){
                    
                    // int k = arr[i] / arr[j];
                    // if(map.containsKey(k))
                    int k = map.getOrDefault(arr[i] / arr[j], -1);
                    if(k != -1)
                        dp[i] += dp[j] * dp[k]; 
                        dp[i] %= 1000000007;
                        // dp[i] = (dp[i] + dp[j] * dp[k]) % 1000000007;
                }                   
                    
            }
        }
        long sum = 0;
        for(long n:dp)
            sum += n;
        return (int) (sum % 1000000007);        
    }
}