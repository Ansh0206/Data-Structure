class Solution {
    public void helper(int n,int k,int i,List<Integer> list,List<List<Integer>> ans){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
           
        }
        for(;i<=n;i++){
            list.add(i);
            helper(n,k,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(n,k,1,new ArrayList<>(),ans);
        return ans;
        
    }
}