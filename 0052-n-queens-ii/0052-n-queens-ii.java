class Solution {
    static int count=0;
    public boolean isSafe(String[][] board,int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col].equals("Q")){
                return false;
            }
        }

        //diagonal left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j].equals("Q")){
                return false;
            }
        }

        //diagonal right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j].equals("Q")){
                return false;
            }
        }
        return true;
    }
    public void nQueens(String[][] board,int row){
        if(row==board.length){
            count++;
            return ;

        }
        for(int i=0;i<board[0].length;i++){
            if(isSafe(board,row,i)){
                board[row][i]="Q";
                nQueens(board,row+1);
                board[row][i]=".";
            }
        }
    }
    public int totalNQueens(int n) {
        count=0;
        String[][] board=new String[n][n];
        for(String[] arr : board){
            Arrays.fill(arr,".");
        }
        nQueens(board,0);
        return count;

        
    }
}