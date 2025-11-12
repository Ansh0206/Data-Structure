class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max=Integer.MIN_VALUE;
        int i=0;
        for(;i<nums.length-1;i++){
            max=Math.max(max,Math.abs(nums[i]-nums[i+1]));
        }
        max=Math.max(max,Math.abs(nums[0]-nums[i]));
        return max;
        
    }
}