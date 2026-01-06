class Solution {
    Integer[][][][][] dp;
    public int helper(String s,int i,int tight,int lz,int mask,int repeat){
        if(i==s.length()){
            return (repeat==1)?0:1;
        }
        if(dp[i][tight][lz][mask][repeat]!=null){
            return dp[i][tight][lz][mask][repeat];
        }

        int lb=0;
        int ub=(tight==1)? s.charAt(i)-'0' : 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newTight=(tight==1 && digit==ub)? 1 :0;
            if(lz==1 && digit==0){
                ans+=helper(s,i+1,newTight,1,mask,repeat);
            }else{
                int isDigitUsed=(mask>>digit) & 1;
                int newRepeat=(repeat==1 || isDigitUsed==1)?1:0;
                int newMask=(1<<digit) | mask;
                ans+=helper(s,i+1,newTight,0,newMask,newRepeat);
            }
            
        }
        return dp[i][tight][lz][mask][repeat]=ans;
    }
    public int countNumbersWithUniqueDigits(int n) {
        String s=String.valueOf((int)Math.pow(10,n)-1);
        dp=new Integer[s.length()][2][2][1024][2];
        return helper(s,0,1,1,0,0);

        
    }
}