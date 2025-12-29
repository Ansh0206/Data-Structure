class Solution {
    public int helper(int[] nums,int i,Integer[] dp){
        if(i>=nums.length){
            return Integer.MAX_VALUE;
        }
        if(i==nums.length-1){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        dp[i]=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            int ans=helper(nums,i+j,dp);
            if(ans!=Integer.MAX_VALUE){
                ans+=1;
            }
            dp[i]=Math.min(ans,dp[i]);
        }
        return dp[i];
    }
    public int jump(int[] nums) {
        Integer[] dp=new Integer[nums.length];
        return helper(nums,0,dp);
        
    }
}