class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    int ans1=curr[j-1];
                    int ans2=prev[j];
                    curr[j]=Math.max(ans1,ans2);
                }
            }
            prev=curr.clone();
        }
        return prev[n];
        
    }
}