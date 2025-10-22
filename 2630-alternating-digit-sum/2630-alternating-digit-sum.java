class Solution {
    public int alternateDigitSum(int n) {
        if(n<=9 && n>=1){
            return n;
        }
        int sum=0;
        String s=String.valueOf(n);
        boolean sign=true;
        if(s.length()%2==0){
            sign=false;
        }
        while(n>0){
            int last=n%10;
            if(!sign){
                sum-=last;
                sign=true;
            }else if(sign){
                sum+=last;
                sign=false;
            }
            n/=10;
        }
        return sum;
        
    }
}