class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] curr=new int[2];
        int[] prev=new int[2];
        //1--> means you can buy the stock(you are not holding any stock)
        //0--> means you cant buy the stock (you are holding a stock) sell it first to buy another stock

        prev[0]=0;
        prev[1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            //two choices
            //buy
            curr[1]=Math.max(-prices[i]+prev[0],prev[1]);
            //sell
            curr[0]=Math.max(prices[i]+prev[1],prev[0]);
            prev=curr;
        }
        return prev[0];  //obviously at the end you nt need to hold any stoch
                            //whats the point of holding if you cant sell it further

    }
}