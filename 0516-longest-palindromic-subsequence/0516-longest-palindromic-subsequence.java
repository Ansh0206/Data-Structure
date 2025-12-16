class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String s2=new StringBuilder(s).reverse().toString();
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);

                }
            }
        }
        return dp[n][n];

        
    }
}