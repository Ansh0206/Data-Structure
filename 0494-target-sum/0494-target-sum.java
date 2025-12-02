class Solution {
    public int helper(int[] nums,int target,int sum,int i){
        if(i==nums.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }
        int plus=helper(nums,target,sum+nums[i],i+1);
        int minus=helper(nums,target,sum-nums[i],i+1);
        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
        
    }
}