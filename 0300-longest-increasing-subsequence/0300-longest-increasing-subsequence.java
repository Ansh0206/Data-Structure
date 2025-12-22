class Solution {
    public int helper(int[] nums,int curr,int prev,Integer[][] dp){
        if(curr==nums.length){
            return 0;
        }
        if(dp[curr][prev+1]!=null){
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
        int[] currArr=new int[n+1];
        int[] nextArr=new int[n+1];
        for(int curr=n-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int take=0;
                if(prev==-1 || nums[curr]>nums[prev]){
                    take=1+nextArr[curr+1];
                }
                int not=nextArr[prev+1];
                currArr[prev+1]=Math.max(take,not);
            }
            nextArr=currArr;
             
        }
        return nextArr[0];
        
    }
}