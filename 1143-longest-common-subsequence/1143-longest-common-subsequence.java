class Solution {
    public int helper(String s,String t,int i,int j,Integer[][] dp){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=1+helper(s,t,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(helper(s,t,i-1,j,dp),helper(s,t,i,j-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        Integer[][] dp=new Integer[m+1][n+1];
        return helper(text1,text2,m,n,dp);
        
    }
}