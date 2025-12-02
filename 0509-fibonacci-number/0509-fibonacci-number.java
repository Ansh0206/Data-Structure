class Solution {
    public int fib(int n) {
        if(n<=0){
            return n;
        }
        int last1=0;
        int last2=1;
        for(int i=2;i<=n;i++){
            int ans=last1+last2;
            last1=last2;
            last2=ans;
        }
        return last2; 
    }
}