class Solution {
    public int helper(int[] nums,int start,int end,Integer[] dp){
        if(start>end){
            return 0;
        }
        //rob current
        if(dp[start]!=null){
            return dp[start];
        }
        int rob=nums[start]+helper(nums,start+2,end,dp);
        //not rob
        int notRob=helper(nums,start+1,end,dp);
        return dp[start]=Math.max(rob,notRob);
    }

    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        Integer[] dp1=new Integer[n];
        Integer[] dp2=new Integer[n];
        int ans1=helper(nums,0,n-2,dp1);
        int ans2=helper(nums,1,n-1,dp2);
        return Math.max(ans1,ans2);
        
    }
}