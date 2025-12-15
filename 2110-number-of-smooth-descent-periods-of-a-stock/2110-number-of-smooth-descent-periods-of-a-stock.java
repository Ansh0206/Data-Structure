class Solution {
    public long getDescentPeriods(int[] prices) {
        long[] dp=new long[prices.length];
        dp[0]=1;
        int count=1;
        for(int i=1;i<dp.length;i++){
            if(prices[i]-prices[i-1]==-1){
                dp[i]=dp[i-1]+count+1;
                count++;
            }else{
                dp[i]=dp[i-1]+1;
                count=1;
                
            }
        }
        return dp[dp.length-1];
        
    }
}