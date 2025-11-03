class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0;
        int greater=0;
        int equal=0;
        for(int i : nums){
            if(i==pivot){
                equal++;
            }else if(i>pivot){
                greater++;
            }else{
                less++;
            }
        }
        int[] lArr=new int[less];
        int[] gArr=new int[greater];
        int[] ans=new int[nums.length];
        int itr=0;
        for(int i : nums){
            if(i>pivot){
                gArr[itr++]=i;

            }
        }
        itr=0;
        for(int i : nums){
            if(i<pivot){
                lArr[itr++]=i;

            }
        }
        itr=0;
        for(int i=0;i<lArr.length;i++){
            ans[itr++]=lArr[i];
        }
        for(int i=0;i<equal;i++){
            ans[itr++]=pivot;
        }
        for(int i=0;i<gArr.length;i++){
            ans[itr++]=gArr[i];
        }
        return ans;
        
    }
}