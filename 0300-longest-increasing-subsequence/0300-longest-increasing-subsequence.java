class Solution {
    public int helper(int[] nums,int curr,int prev,int[][] dp){
        if(curr==nums.length){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        int take=0;
        if(prev==-1 || nums[curr]>nums[prev]){
            take=1+helper(nums,curr+1,curr,dp);
        }
        int not=helper(nums,curr+1,prev,dp);
        return dp[curr][prev+1]=Math.max(take,not);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(nums,0,-1,dp);
        
    }
}