class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[]pre = new int[target + 1];
        Arrays.fill(pre, 1, Math.min(k, target) + 1, 1);
        for(int numDice = 2; numDice <= n; numDice++){
            int[]cur = new int[target + 1];
            int maxSum = Math.min(target, numDice * k);
            for(int sum = numDice; sum <= maxSum; sum++){
                int maxFace = Math.min(k, sum);
                for(int face = 1; face <= maxFace; face++)
                    cur[sum] = (cur[sum] + pre[sum - face]) % 1_000_000_007;                
            }
            pre = cur;
        }
        return (int)pre[target];
    }
}