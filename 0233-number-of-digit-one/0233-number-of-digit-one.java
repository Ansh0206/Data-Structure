class Solution {
    Integer[][][] dp;
    static  final int size=10;
    public int helper(String s,int i,int tight,int count){
        if(i==s.length()){
            return count;
        }
        if(dp[i][tight][count]!=null){
            return dp[i][tight][count];
        }
        int lb=0;
        int ub=(tight==1)? s.charAt(i)-'0' : 9;
        int ans=0;
        for(int digit=0;digit<=ub;digit++){
            int newTight=(tight==1 && digit==ub)?1:0;
            if(digit==1){
                ans+=helper(s,i+1,newTight,count+1);
            }else{
                ans+=helper(s,i+1,newTight,count);
            }
        }
        return dp[i][tight][count]=ans;
    }
    public int countDigitOne(int n) {
        String s=String.valueOf(n);
        dp=new Integer[size][2][size];
        return helper(s,0,1,0);
        
    }
}