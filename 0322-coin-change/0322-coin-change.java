class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        dp[0][0]=0;
        for(int i=1;i<dp[0].length;i++){
            if(i%coins[0]!=0){
                dp[0][i]=Integer.MAX_VALUE;
            }else{
                dp[0][i]=i/coins[0];
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int notPick=dp[i-1][j];
                int pick=Integer.MAX_VALUE;
                if(j>=coins[i] && dp[i][j-coins[i]]!=Integer.MAX_VALUE){
                    pick=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(pick,notPick);
            }
        }
        if(dp[dp.length-1][dp[0].length-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[dp.length-1][dp[0].length-1];

        
    }
}