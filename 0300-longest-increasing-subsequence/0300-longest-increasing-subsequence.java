class Solution {
// public int helper(int[] nums,int curr,int prev,int[][] dp){
//     if(curr==nums.length){
//         return 0;
//     }
//     if(dp[curr][prev+1]!=-1){
//         return dp[curr][prev+1];
//     }
//     int take=0;
//     if(prev==-1 || nums[curr]>nums[prev]){
//         take=1+helper(nums,curr+1,curr,dp);
//     }
//     int not=helper(nums,curr+1,prev,dp);
//     return dp[curr][prev+1]=Math.max(take,not);
// }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int curr=n-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int take=0;
                if(prev==-1 || nums[curr]>nums[prev]){
                    take=1+dp[curr+1][curr+1];
                }
                int not=dp[curr+1][prev+1];
                dp[curr][prev+1]=Math.max(take,not);
            }
        }
        return dp[0][0];
    }
}