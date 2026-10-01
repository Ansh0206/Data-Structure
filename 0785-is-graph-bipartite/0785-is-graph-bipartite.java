class Solution {
    public boolean dfs(int root,int[][] graph,int[] color){
        for(int nn : graph[root]){
            if(color[nn]==color[root]){
                return false;
            }else if(color[nn]==-1){
                color[nn]=1-color[root];
                if(!dfs(nn,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=0;

                if(!dfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
        
    }
}