class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        if(nums[0]==0){
            while(nums[i]!=1){
                i++;
                if(i==nums.length){
                    return true;
                }
            }

        }
        i++;
        int count=0;

        for(;i<nums.length;i++){

            if(nums[i]==1 && count<k){
                return false;
            }else if(nums[i]==1 && count>=k){
                count=0;
            }else{
                count++;
            }
        }
        return true;
        
    }
}