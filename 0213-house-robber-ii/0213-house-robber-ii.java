class Solution {
    public int helper(int[] nums,int start,int end){
        int last=0;
        int secondLast=0;
        int ans=-1;
        for(int i=start;i<=end;i++){
            ans=Math.max(secondLast,nums[i]+last);
            last=secondLast;
            secondLast=ans;
        }
        return ans;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int ans1=helper(nums,0,n-2);
        int ans2=helper(nums,1,n-1);
        return Math.max(ans1,ans2);
        
    }
}