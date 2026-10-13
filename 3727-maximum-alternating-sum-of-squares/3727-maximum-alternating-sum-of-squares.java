class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans=0;

        int left=0;
        int right=nums.length-1;

        while(left<=right){
            if(left==right){
                ans+=nums[right]*nums[right];
                break;

            }

            ans+=nums[right]*nums[right] - nums[left]*nums[left];
            right--;
            left++;
        }
        return ans;
        
    }
}