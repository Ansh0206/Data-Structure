class Solution {
    Integer[][][][][] dp;
    public int helper(String s,int index,int tight,int repeated,int mask,int lz){
        if(index==s.length()){
            return repeated;
        }
        if(dp[index][tight][repeated][mask][lz]!=null){
            return dp[index][tight][repeated][mask][lz];
        }
        int lb=0;
        int ub=(tight==1)? s.charAt(index)-'0' : 9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int newTight=(tight==1 && digit==ub)? 1: 0;
            if(lz==1 && digit==0){
                res+=helper(s,index+1,newTight,repeated,mask,lz);
            }else{
                int isDigitUsed=1 & (mask>>digit);
                int newRepeated=(repeated==1 || isDigitUsed==1)?1:0;
                int newMask=(1<<digit) | mask;
                res+=helper(s,index+1,newTight,newRepeated,newMask,0);
            }
        }
        return dp[index][tight][repeated][mask][lz]=res;
    }
    public int numDupDigitsAtMostN(int n) {
        String s=String.valueOf(n);
        dp=new Integer[11][2][2][1024][2];
        return helper(s,0,1,0,0,1);  //index,tight,repeated,masking,leading zeroes
        
    }
}