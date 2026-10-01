class Solution {
    public boolean dfs(int root,List<List<Integer>> list,int[] color){
        for(int nn : list.get(root)){
            if(color[nn]==-1){
                color[nn]=1-color[root];
                if(!dfs(nn,list,color)){
                    return false;
                }
            }else if(color[nn]==color[root]){
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList());
        }

        for(int[] arr : dislikes){
            int u=arr[0];
            int v=arr[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                color[i]=0;

                if(!dfs(i,list,color)){
                    return false;
                }
            }
        }
        return true;

        
    }
}