class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int itr=0;
        for(int i : nums){
            if(i>0){
                pos[itr++]=i;
            }
        }
        itr=0;
        for(int i : nums){
            if(i<0){
                neg[itr++]=i;
            }
        }
        itr=0;
        int i=0;
        while(i<ans.length){
            ans[i++]=pos[itr];
            ans[i++]=neg[itr++];
        }
        return ans;
    }
}