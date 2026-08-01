class Solution {
    public int helper(int i, int j, int[] nums, int[][] dp){
        if(i==j){
            return nums[i];
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }

        int left=nums[i]-helper(i+1,j,nums,dp);
        int right=nums[j]-helper(i,j-1,nums,dp);
        return dp[i][j]=Math.max(left,right);
    }

    public boolean predictTheWinner(int[] nums){
        int n=nums.length;
        int[][] dp=new int[n][n];
        for (int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int ans=helper(0,n-1,nums,dp);
        if(ans>=0){
            return true;
        }
        return false;
    }
}