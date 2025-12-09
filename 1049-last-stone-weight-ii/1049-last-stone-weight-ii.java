class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i : stones){
            sum+=i;
        }
        int n=stones.length;
        boolean[][] dp=new boolean[n][(sum/2)+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<dp[0].length;i++){
            int curr=stones[0];
            if(i-curr==0){
                dp[0][i]=true;
            }else{
                dp[0][i]=false;
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int curr=stones[i];
                if(j==curr){
                    dp[i][j]=true;
                }else if(j>curr){
                    dp[i][j]=dp[i-1][j-curr] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int ans=-1;
        for(int i=dp[0].length-1;i>=0;i--){
            if(dp[dp.length-1][i]==true){
                ans=i;
                break;
            }
        }
        int secondAns=Math.abs(sum-ans);
        return Math.abs(ans-secondAns);
        
    }
}