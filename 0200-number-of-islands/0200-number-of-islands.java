class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public void dfs(char[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i==rowL || j==colL || vis[i][j]==true){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        vis[i][j]=true;
        for(int index=0;index<4;index++){
            int newRow=i+dr[index];
            int newCol=j+dc[index];
            dfs(grid,vis,newRow,newCol);
        }
    }

    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<colL;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    dfs(grid,vis,i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
}