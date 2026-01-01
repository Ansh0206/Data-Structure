class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==1){
                    int yes=-prices[i]+dp[i+1][0];
                    int no=dp[i+1][1];
                    dp[i][j]=Math.max(dp[i][j],Math.max(yes,no));
                }else{
                    int yes=prices[i]+dp[i+1][1];
                    int no=dp[i+1][0];
                    dp[i][j]=Math.max(dp[i][j],Math.max(yes,no));
                }
            }
        }
        return dp[0][1];


        
    }
}