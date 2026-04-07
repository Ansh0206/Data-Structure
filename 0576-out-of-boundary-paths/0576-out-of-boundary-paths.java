class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    int M;
    int N;
    static int mod=1000000007;
    public int helper(int i,int j,int max,Integer[][][] dp){
       
        if(i>=M || j>=N || i<0 || j<0){
            return 1;
        }
        if(max==0){
            return 0;
        }
        if(dp[i][j][max]!=null){
            return dp[i][j][max];
        }
        int ans=0;
        for(int idx=0;idx<4;idx++){
            ans=(ans+helper(i+dr[idx],j+dc[idx],max-1,dp))%mod;
        }
        return dp[i][j][max]=ans;



    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M=m;
        N=n;
        Integer[][][] dp=new Integer[M+1][N+1][maxMove+1];
        return helper(startRow,startColumn,maxMove,dp);
        
    }
}