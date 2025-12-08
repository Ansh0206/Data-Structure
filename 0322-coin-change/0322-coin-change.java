class Solution {
    public int helper(int[] coins,int amount,int i,Integer[][] dp){
        if(amount==0){
            return 0;
        }
        if(amount<0 || i==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=null){
            return dp[i][amount];
        }
        int same=helper(coins,amount-coins[i],i,dp);
        if(same!=Integer.MAX_VALUE){
            same+=1;
        }
        int different=helper(coins,amount,i+1,dp);
        dp[i][amount]=Math.min(same,different);
        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp=new Integer[coins.length][amount+1];
        int ans=helper(coins,amount,0,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        
    }
}