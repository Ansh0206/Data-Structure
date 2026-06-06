class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] suff=new int[n];

        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]+nums[i];
        }

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(pre[i]-suff[i]);
        }
        return ans;
        
    }
}