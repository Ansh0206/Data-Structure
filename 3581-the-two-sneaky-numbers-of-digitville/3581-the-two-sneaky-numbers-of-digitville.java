class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr=new int[101];
        for(int i : nums){
            arr[i]++;
        }
        int[] ans=new int[2];
        int itr=0;
        for(int i=0;i<arr.length;i++){
            if(itr==2){
                break;

            }
            if(arr[i]==2){
                ans[itr++]=i;
            }
        }
        return ans;
        
    }
}