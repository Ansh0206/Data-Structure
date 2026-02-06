class Solution {
    public void dfs(int[][] grid,boolean[] vis,int city){
        vis[city]=true;
        for(int i=0;i<grid.length;i++){
            if(!vis[i] && grid[city][i]==1){
                dfs(grid,vis,i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                count++;
            }
        }
        return count;
        
    }
}