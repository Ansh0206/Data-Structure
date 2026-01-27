class Solution {
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
    public void nQueens(String[][] board,int row,List<List<String>> res){
        if(row==board.length){
            List<String> list=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<board.length;j++){
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(new ArrayList<>(list));
            return ;

        }
        for(int i=0;i<board[0].length;i++){
            if(isSafe(board,row,i)){
                board[row][i]="Q";
                nQueens(board,row+1,res);
                board[row][i]=".";
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        String[][] board=new String[n][n];
        for(String[] arr : board){
            Arrays.fill(arr,".");
        }
        List<List<String>> res=new ArrayList<>();
        nQueens(board,0,res);
        return res;

        
    }
}