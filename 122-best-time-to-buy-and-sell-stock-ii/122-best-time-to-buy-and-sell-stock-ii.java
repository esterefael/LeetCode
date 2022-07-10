class Solution {
    public int maxProfit(int[] prices) {
        int sum=0;
        int buyAndSell;
        int prev=prices[0];

        for(int i=1; i<prices.length; i++){       
            buyAndSell=prices[i]-prev;
            prev=prices[i];
            sum+=(buyAndSell>0?buyAndSell:0);
        }

        return sum;        
    }
}