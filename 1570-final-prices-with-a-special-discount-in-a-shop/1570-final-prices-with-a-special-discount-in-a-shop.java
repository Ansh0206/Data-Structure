class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int j=i+1;
            for(;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    ans[i]=prices[i]-prices[j];
                    break;
                }
            }
            if(j==prices.length && ans[i]==0){
                ans[i]=prices[i];
            }
        }
        return ans;
        
    }
}