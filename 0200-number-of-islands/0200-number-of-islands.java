class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static char[] directions={'U','D','L','R'};

    static class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(char[][] grid,boolean[][] vis,int i,int j){
        Queue<Pair> q=new LinkedList<>();
        vis[i][j]=true;
        q.offer(new Pair(i,j));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;

            for(int index=0;index<4;index++){
                int nRow=row+dr[index];
                int nCol=col+dc[index];

                if(nRow>=0 && nCol>=0 && nRow<rowL && nCol<colL  && !vis[nRow][nCol] && grid[nRow][nCol]=='1'){
                    vis[nRow][nCol]=true;
                    q.offer(new Pair(nRow,nCol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        
        int components=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    bfs(grid,vis,i,j);
                    components++;
                    
                }
            }
        }
        return components;
        
    }
}