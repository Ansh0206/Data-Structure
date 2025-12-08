class Solution {
    public int helper(int[][] dungeon,int i,int j,int[][] dp){
        if(i==dungeon.length || j==dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==dungeon.length-1 && j==dungeon[0].length-1){
            return Math.max(1,1-dungeon[i][j]);
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int right=helper(dungeon,i,j+1,dp);
        int down=helper(dungeon,i+1,j,dp);
        int required=Math.min(right,down);
        dp[i][j]= Math.max(1,required-dungeon[i][j]);
        return dp[i][j];
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] dp=new int[m][n];
        return helper(dungeon,0,0,dp);
        
    }
}