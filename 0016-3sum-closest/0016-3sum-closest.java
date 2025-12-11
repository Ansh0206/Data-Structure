class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    int rem=Math.abs(target-sum);
                    if(rem<=min){
                        min=rem;
                        ans=sum;
                    }
                }
            }
        }
        return ans;
        
    }
}