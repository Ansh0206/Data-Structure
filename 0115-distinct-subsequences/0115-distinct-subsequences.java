class Solution {
    public int helper(String s,String t,int i,int j,Integer[][] dp){
        if(j==0){
            return 1;
        }
        if(i==0){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=helper(s,t,i-1,j-1,dp)+helper(s,t,i-1,j,dp);
        }else{
            return dp[i][j]=helper(s,t,i-1,j,dp);
        }
    }
    public int numDistinct(String s, String t) {
        Integer[][] dp=new Integer[s.length()+1][t.length()+1];

        return helper(s,t,s.length(),t.length(),dp);
        
    }
}