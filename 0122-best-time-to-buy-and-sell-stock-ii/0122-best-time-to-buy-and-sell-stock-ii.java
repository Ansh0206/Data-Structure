class Solution {
    public int helper(int[] prices,int i,int buy,Integer[][] dp){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy]!=null){
            return dp[i][buy];
        }
        int profit=0;
        if(buy==1){
            int yes=-prices[i]+helper(prices,i+1,0,dp);
            int no=helper(prices,i+1,1,dp);
            profit=Math.max(profit,Math.max(yes,no));
        }else{
            int yes=prices[i]+helper(prices,i+1,1,dp);
            int no=helper(prices,i+1,0,dp);
            profit=Math.max(profit,Math.max(yes,no));
        }
        return dp[i][buy]=profit;

    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return helper(prices,0,1,dp);

        
    }
}