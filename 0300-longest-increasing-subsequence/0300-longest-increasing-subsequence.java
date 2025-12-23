class Solution {
    public int helper(ArrayList<Integer> list,int n){
        int start=0;
        int end=list.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(list.get(mid)==n){
                return mid;
            }
            if(list.get(mid)>n){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int index=helper(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        return list.size();
    }
}