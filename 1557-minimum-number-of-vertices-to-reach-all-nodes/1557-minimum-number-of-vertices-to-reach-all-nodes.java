class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] arr=new int[n];
        for(List<Integer> l : edges){
            int v=l.get(1);
            arr[v]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                ans.add(i);
            }
        }
        return ans;

        
    }
}