class Solution {
    public boolean binary(int[] nums,int el){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==el){
                return true;
            }
            if(nums[mid]>el){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;

    }
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int curr=original;
        while(true){
            boolean ans=binary(nums,curr);
            if(!ans){
                return curr;
            }else{
                curr=curr*2;
            }
        }
        
    }
}