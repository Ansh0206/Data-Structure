class Solution {
    static int rowL;
    static int colL;

    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i==rowL || j==colL || grid[i][j]==0){
            return 1;
        }
        if(grid[i][j]==2){
            return 0;
        }
        grid[i][j]=2;
        int len=0;
        for(int index=0;index<4;index++){
            len+=dfs(grid,i+dr[index],j+dc[index]);
        }
        return len;
    }
    public int islandPerimeter(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j);
                }
            }
        }
        return -1;
    }
}