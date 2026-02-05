class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public void dfs(int row,int col,boolean[][] vis,char[][] grid){
        if(row<0 || row>=rowL || col<0 || col>=colL || grid[row][col]=='0'){
            return;
        }
        if(vis[row][col]==true){
            return;
        }
        vis[row][col]=true;
        
        for(int i=0;i<=3;i++){
            dfs(row+dr[i],col+dc[i],vis,grid);
        }
    }
    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int components=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                //System.out.println("hi");
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,vis,grid);
                   // System.out.println("hi");
                    components++;
                }
                
               
            }
        }
        return components;

        
    }
}