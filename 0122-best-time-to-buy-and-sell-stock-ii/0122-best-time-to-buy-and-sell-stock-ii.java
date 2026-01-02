class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        //1--> means you can buy the stock(you are not holding any stock)
        //0--> means you cant buy the stock (you are holding a stock) sell it first to buy another stock

        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<dp.length;i++){
            //two choices
            //buy
            dp[i][1]=Math.max(-prices[i]+dp[i-1][0],dp[i-1][1]);
            //sell
            dp[i][0]=Math.max(prices[i]+dp[i-1][1],dp[i-1][0]);
        }
        return dp[n-1][0];  //obviously at the end you nt need to hold any stoch
                            //whats the point of holding if you cant sell it further
                            
    }
}