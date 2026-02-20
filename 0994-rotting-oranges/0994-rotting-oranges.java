class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int fresh=0;
    int maxTime=0;

    public class Pair{
        int r;
        int c;
        int t;
        Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }

    public int orangesRotting(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        fresh=0;
        boolean[][] vis=new boolean[rowL][colL];
        Queue<Pair> q=new  LinkedList<>();
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.r;
            int c=curr.c;
            int t=curr.t;
            maxTime=Math.max(t,maxTime);

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && ncol>=0 && nrow<rowL && ncol<colL && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    fresh--;
                    vis[nrow][ncol]=true;

                }
            }
        }
        return (fresh==0) ? maxTime : -1;
    }
}