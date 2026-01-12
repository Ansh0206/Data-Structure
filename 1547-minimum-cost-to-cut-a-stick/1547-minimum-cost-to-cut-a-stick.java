class Solution {
    public int helper(int i,int j,ArrayList<Integer> list,Integer[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int ans1=list.get(j+1)-list.get(i-1);
            int ans2=helper(i,k-1,list,dp);
            int ans3=helper(k+1,j,list,dp);
            int total=ans1+ans2+ans3;
            min=Math.min(min,total);
        }
        return dp[i][j]=min;
        

    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        for(int i=0;i<cuts.length;i++){
            list.add(cuts[i]);
        }
        list.add(n);
        Integer[][] dp=new Integer[list.size()+1][list.size()+1];
        return helper(1,cuts.length,list,dp);          //1,4

        
    }
}