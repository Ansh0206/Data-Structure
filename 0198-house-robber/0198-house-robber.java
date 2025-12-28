class Solution {
    public int helper(int[] nums,int i,Integer[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        //rob the house
        int rob=nums[i]+helper(nums,i+2,dp);
        //not rob
        int notRob=helper(nums,i+1,dp);
        return dp[i]=Math.max(rob,notRob);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        Integer[] dp=new Integer[n];
        return helper(nums,0,dp);
        
    }
}