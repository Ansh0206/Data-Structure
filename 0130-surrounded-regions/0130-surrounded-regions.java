class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public void dfs(char[][] board,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i==rowL || j==colL || board[i][j]=='X'){
            return;
        }
        if(vis[i][j]==true){
            return;
        }
        vis[i][j]=true;
        for(int index=0;index<4;index++){
            dfs(board,vis,i+dr[index],j+dc[index]);
        }
    }
    public void solve(char[][] board) {
        rowL=board.length;
        colL=board[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if((i==0 || j==0 || i==rowL-1 || j==colL-1) &&board[i][j]=='O'){
                    dfs(board,vis,i,j);
                }
            }
        }
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(vis[i][j]==false && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        
    }
}