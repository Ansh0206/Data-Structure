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
        int[] prevArr=new int[n+1];
        int[] currArr=new int[n+1];
        for(int curr=n-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int take=0;
                if(prev==-1 || nums[curr]>nums[prev]){
                    take=1+prevArr[curr+1];
                }
                int not=prevArr[prev+1];
                currArr[prev+1]=Math.max(take,not);
            }
            prevArr=currArr.clone();
        }
        return prevArr[0];
    }
}