class Solution {
    public int helper(int[] cost,int[] dp,int i){
        if(i==0 || i==1){
            dp[i]=cost[i];
            return dp[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        dp[i]=cost[i]+Math.min(helper(cost,dp,i-1),helper(cost,dp,i-2));
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==2){
            return Math.min(cost[0],cost[1]);
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        helper(cost,dp,n-1);
        return Math.min(dp[n-1],dp[n-2]);
        
    }
}