class Solution {
    public int helper(int[] prices,int i,int buy,int count,int[][][] dp){
        if(count==0){
            return 0;
            //cant buy more stocks
        }
        if(i==prices.length){
            return 0;
            //no more stocks left to buy or sell
        }
        if(dp[i][buy][count]!=-1){
            return dp[i][buy][count];
        }
        int profit=0;
        if(buy==1){
            //means you can buy the stock (not holding anything)
            int yes=-prices[i]+helper(prices,i+1,0,count,dp);
            int no=helper(prices,i+1,1,count,dp);
            profit=Math.max(yes,no);
        }else{
            //you cant buy you can sell or not sell
            int yes=prices[i]+helper(prices,i+1,1,count-1,dp);
            int no=helper(prices,i+1,0,count,dp);
            profit=Math.max(yes,no);

        }
        return dp[i][buy][count]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int[][] arr : dp){
            for(int[] ar : arr){
                Arrays.fill(ar,-1);
            }
        }
        return helper(prices,0,1,2,dp);
        
    }
}