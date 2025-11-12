class Solution {
    public int digitSum(int n){
        int ans=0;
        while(n>0){
            int last=n%10;
            ans+=last;
            n/=10;
        }
        return ans;
    }
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=digitSum(nums[i]);
        }
        int min=Integer.MAX_VALUE;
        for(int i : nums){
            min=Math.min(min,i);
        }
        return min;
        
    }
}