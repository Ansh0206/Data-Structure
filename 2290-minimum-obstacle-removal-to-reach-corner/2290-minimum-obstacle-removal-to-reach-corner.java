class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public class Pair{
        int row;
        int col;
        int h;
        Pair(int row,int col,int h){
            this.row=row;
            this.col=col;
            this.h=h;
        }
    }
    public int minimumObstacles(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        int h=0;
        boolean[][] vis=new boolean[rowL][colL];
        vis[0][0]=true;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b) -> Integer.compare(a.h,b.h));
        if(grid[0][0]==1){
            q.add(new Pair(0,0,1));
        }else{
            q.add(new Pair(0,0,0));

        }
        
        while(!q.isEmpty()){
            Pair n=q.poll();
            int row=n.row;
            int col=n.col;
            int he=n.h;

            if(row==rowL-1 && col==colL-1){
                return he;
            }
            
            for(int i=0;i<4;i++){
                int nRow=row+dr[i];
                int nCol=col+dc[i];
                int newH=he;

                if(nRow>=0 && nCol>=0 && nRow<rowL && nCol<colL && !vis[nRow][nCol]){
                    if(grid[nRow][nCol]==1){
                       newH++;
                    }
                    vis[nRow][nCol]=true;
                    q.add(new Pair(nRow,nCol,newH));
                  
                    
                }
            }
        }
        return -1;
       
    }
}