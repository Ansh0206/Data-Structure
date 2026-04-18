class Solution {
    public int helper(int n){
        int ans=0;
        while(n>0){
            int last=n%10;
            ans=ans*10+last;
            n=n/10;
            
        }
        return ans;
    }
    public int mirrorDistance(int n) {
        int reverse=helper(n);
        return Math.abs(n-reverse);
        
    }
}