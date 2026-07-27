class Solution {
    public int maxProduct(int[] nums) {
        int first=0;
        int second=0;
        int index=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>first){
                first=nums[i];
                index=i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i==index){
                continue;
            }
            if(nums[i]>second){
                second=nums[i];
            }
        }
        return (first-1)*(second-1);
        
    }
}