class Solution {
    static int rowl;
    static int coll;
    static int[] dc={-1,0,1};
    Integer[][][] dp;

    public int helper(int r,int c1,int c2,int[][] grid){
        if(c1<0 || c1>=coll || c2<0 || c2>=coll){
            return -1;
        }
        if(dp[r][c1][c2]!=null){
            return dp[r][c1][c2];
        }
        if(r==rowl-1){
            if(c1==c2){
                return grid[r][c1];
            }
            return grid[r][c1]+grid[r][c2];
        }
        int curr;
        if(c1==c2){
            curr=grid[r][c1];
        }else{
            curr=grid[r][c1]+grid[r][c2];
        }

        int max=-1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int ans=curr+helper(r+1,c1+dc[i],c2+dc[j],grid);
                max=Math.max(max,ans);
            }
        }
        return dp[r][c1][c2]=max;
    }
    public int cherryPickup(int[][] grid) {
        rowl=grid.length;
        coll=grid[0].length;
        dp=new Integer[rowl][coll][coll];
        return helper(0,0,coll-1,grid); 
        
        
    }
}