class Solution {
    public boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int helper(int i,String s,Integer[] dp){
        if(i==s.length()){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            int ans1=0;
            int ans2=0;
            if(isPalindrome(i,j,s)){
                int cost=1+helper(j+1,s,dp);
                min=Math.min(min,cost);
            } 
        }
        return dp[i]=min;
    }
    public int minCut(String s) {
        int n=s.length();
        Integer[] dp=new Integer[n+1];
        return helper(0,s,dp)-1;
        
    }
}