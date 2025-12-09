class Solution {
    public void helper(int[] arr,int target,List<List<Integer>> ans,List<Integer> list,int i){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i<0 || target<0){
            return;
        }
        int prev=i-1;
        while(prev>=0 && arr[prev]==arr[i]){
            prev--;
        }
        list.add(arr[i]);
        helper(arr,target-arr[i],ans,list,i-1);
        list.remove(list.size()-1);
        helper(arr,target,ans,list,prev);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,ans,new ArrayList<>(),candidates.length-1);
        return ans;
        
    }
}