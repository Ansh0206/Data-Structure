class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public int helper(int[][] grid,int row, int col,boolean[][] vis){
        if(row<0 || row>=rowL || col<0 || col>=colL || grid[row][col]==0){
            return 0;
        }
        if(vis[row][col]){
            return 0;
        }

        vis[row][col]=true;
        int ans=1;
        for(int i=0;i<=3;i++){
            ans+=helper(grid,row+dr[i],col+dc[i],vis);
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]!=0 && vis[i][j]==false){
                    max=Math.max(max,helper(grid,i,j,vis));

                }
            }
        }
        return max;
        
    }
}