class Solution {
    public int countPartitions(int[] nums) {
        int[] pre=new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=nums[i]+pre[i-1];
        }
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(Math.abs(pre[i]-(pre[nums.length-1]-pre[i]))%2==0){
                count++;
            }
        }
        return count;
        
    }
}