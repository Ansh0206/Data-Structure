class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        int itr=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[itr++]=nums[i];
            }
        }
        while(itr<nums.length){
            nums[itr++]=0;
        }
        return nums;
        
    }
}