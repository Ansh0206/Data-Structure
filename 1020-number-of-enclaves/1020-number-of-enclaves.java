class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public void dfs(int[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i==rowL || j==colL || grid[i][j]==0){
            return;
        }
        if(vis[i][j]){
            return;
        }
        vis[i][j]=true;
        for(int index=0;index<=3;index++){
            int row=i+dr[index];
            int col=j+dc[index];
            dfs(grid,vis,row,col);

        }
    }
    public int numEnclaves(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if((i==0 || j==0 || i==rowL-1 || j==colL-1) && grid[i][j]==1 && vis[i][j]==false){
                    dfs(grid,vis,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;


        
    }
}