class Solution {
    public int helper(int[][] grid,int i,int j,int [][] dp){
        if(i==grid.length|| j==grid[0].length){
            return 10000050;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=grid[i][j]+helper(grid,i,j+1,dp);
        int down=grid[i][j]+helper(grid,i+1,j,dp);
        dp[i][j]=Math.min(down,right);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(grid,0,0,dp);
        
    }
}