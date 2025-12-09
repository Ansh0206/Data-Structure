class Solution {
    public int helper(int amount,int[] coins,int i,int[][] dp){
        if(amount==0){
            return 1;
        }
        if(i<0 || amount<0){
            return 0;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        int same=helper(amount-coins[i],coins,i,dp);
        int diff=helper(amount,coins,i-1,dp);
        return dp[i][amount]=same+diff;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(amount,coins,coins.length-1,dp);
        
    }
}