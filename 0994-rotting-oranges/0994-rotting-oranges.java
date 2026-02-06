class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    int maxTime=0;

    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        //boolean[][] vis=new booleqan[rowl][colL];

        int fresh=0;
        Queue<Pair> q=new LinkedList<>();

        //add all the rooten orange into the queue
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==2){   //2-->rotten ornges
                    q.offer(new Pair(i,j,0));
                }else if(grid[i][j]==1){    //1-->fresh oranges
                    fresh++;
                }  
            }
        }
        if(fresh==0){
            return 0;
        }

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int time=curr.time;

            maxTime=Math.max(maxTime,time);
            // if(fresh==0){
            //     break;
            // }

            for(int i=0;i<4;i++){
                int newRow=row+dr[i];
                int newCol=col+dc[i];

                //check valid and add into queue
                if(newRow>=0 && newCol>=0 && newRow<rowL && newCol<colL && grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    fresh--;
                    q.offer(new Pair(newRow,newCol,time+1));
                }
            }

        }
        return(fresh==0)? maxTime : -1;

        
    }
}