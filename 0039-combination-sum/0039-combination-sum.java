class Solution {
    public void helper(int[] arr,int target,List<List<Integer>> ans,List<Integer> list,int i){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i<0 || target<0){
            return;
        }
        list.add(arr[i]);
        helper(arr,target-arr[i],ans,list,i);
        list.remove(list.size()-1);
        helper(arr,target,ans,list,i-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,ans,new ArrayList<>(),candidates.length-1);
        return ans;
        
    }
}