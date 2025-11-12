class Solution {
    public int minimumSum(int[] nums) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                if(nums[i]>=nums[j]){
                    continue;
                }
                for(int k=j+1;k<nums.length;k++){
                    if(nums[k]<nums[j]){
                        sum=nums[i]+nums[j]+nums[k];
                        min=Math.min(min,sum);
                    }
                }
            }
        }
        if(sum==0){
            return -1;
        }
        return min;
        
    }
}