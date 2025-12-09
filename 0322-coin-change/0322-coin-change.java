class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        dp[0][0]=0;
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;

        }
        for(int i=1;i<dp[0].length;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j && dp[i][j-coins[i]]!=Integer.MAX_VALUE){
                    take=1+dp[i][j-coins[i]];
                }
                int nTake=dp[i-1][j];
                dp[i][j]=Math.min(take,nTake);
            }
        }
        if(dp[dp.length-1][dp[0].length-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[dp.length-1][dp[0].length-1];

        
    }
}