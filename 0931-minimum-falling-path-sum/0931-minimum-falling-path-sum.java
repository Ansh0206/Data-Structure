class Solution {
    Integer[][] dp;
    public int helper(int i,int j,int[][] matrix){
        
        if(i>=matrix.length || j<0 || j>=matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int down=helper(i+1,j,matrix);
        int ld=helper(i+1,j-1,matrix);
        int rd=helper(i+1,j+1,matrix);

        return dp[i][j]=Math.min(down,Math.min(ld,rd))+matrix[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        dp=new Integer[m][n];
        for(int i=0;i<n;i++){
            ans=Math.min(ans,helper(0,i,matrix));
        }  
        return ans;      
    }
}