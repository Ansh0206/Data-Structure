class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int currP=prices[i]-min;
            profit=Math.max(profit,currP);
            min=Math.min(min,prices[i]);
        }
        return profit;
        
    }
}