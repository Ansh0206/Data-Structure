class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int itr=0;
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        
        while(itr<n){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    continue;
                }
                if(!list.contains(nums[i])){
                    list.add(nums[i]);
                    nums[i]=0;
                    itr++;

                }
            }
            res.add(list);
            
        }
        return res;

        
    }
}