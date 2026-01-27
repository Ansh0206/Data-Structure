class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]<=j){
                    int yes=dp[i][j-coins[i-1]];
                    if(yes!=Integer.MAX_VALUE){
                        yes+=1;
                    }
                    int no=dp[i-1][j];
                    dp[i][j]=Math.min(yes,no);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==Integer.MAX_VALUE ? -1: dp[n][amount];
        
    }
}