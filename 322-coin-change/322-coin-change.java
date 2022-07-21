class Solution {

        public int coinChange(int[] coins, int amount) {
        int [] minNumCoins=new int [amount+1];
        Arrays.fill(minNumCoins,Integer.MAX_VALUE - 1);
        minNumCoins[0]=0;
        for(int i=1;i<=amount;i++)
            for(int j=0;j<coins.length;j++)    
                if(coins[j]<=i)
                    minNumCoins[i]=Math.min(minNumCoins[i], minNumCoins[i-coins[j]]+1);
        return minNumCoins[amount]>=Integer.MAX_VALUE-1?-1:minNumCoins[amount];
    }
}
