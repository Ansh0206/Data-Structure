class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans=new int[nums.length];
        int itr=0;
        for(int i : nums){
            if(i<pivot){
                ans[itr++]=i;
            }
        }
        for(int i : nums){
            if(i==pivot){
                ans[itr++]=i;
            }
        }
        for(int i : nums){
            if(i>pivot){
                ans[itr++]=i;
            }
        }
        return ans;
        
    }
}