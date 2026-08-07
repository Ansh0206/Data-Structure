class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];

        int RANGE = 10000;
        int[] dp = new int[RANGE + 1];
        for(int n : nums)dp[n] += n;
    
        int max = dp[1];
        for(int i =2; i<RANGE + 1; i ++){
            dp[i] = Math.max(dp[i-1], dp[i] + dp[i-2]);
            if(dp[i] > max)max = dp[i];
        }
        
        return max;
    }
}