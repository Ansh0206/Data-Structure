class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public int helper(int[][] grid,int i,int j,boolean[][] vis){
        if(i<0 || j<0 || i>=rowL || j>=colL){
            return 1;
        }
        if(grid[i][j]==0){
            return 1;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j]=true;
        int ans=0;
        for(int index=0;index<=3;index++){
            ans+=helper(grid,i+dr[index],j+dc[index],vis); 
        }
        return ans;
    }
    public int islandPerimeter(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int i=0;
        int j=0;
        for(i=0;i<rowL;i++){
            for(j=0;j<colL;j++){
                if(grid[i][j]==1){
                    return helper(grid,i,j,vis);
                }
            }
        }
        return -1;
        
    }
}