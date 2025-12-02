class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int last=nums[0];
        if(n==1){
            return last;
        }
        int secondLast=-1;
        if(n>1){
            secondLast=Math.max(nums[0],nums[1]);
        }
        if(n==2){
            return secondLast;
        }
        int ans=-1;
        for(int i=2;i<n;i++){
            ans=Math.max(secondLast,nums[i]+last);
            last=secondLast;
            secondLast=ans;
        }
        return ans;
        
        
    }
}