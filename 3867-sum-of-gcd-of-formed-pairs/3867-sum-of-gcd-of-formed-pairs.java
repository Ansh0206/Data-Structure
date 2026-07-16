class Solution {
    public long  gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n =nums.length;
        long[] maxarr=new long[n];
        maxarr[0]=nums[0];
        for(int i=1;i<n;i++){
            maxarr[i]=Math.max(maxarr[i-1],nums[i]);
        }
        long[] prefixGcd=new long[n];
        for(int i=0;i<n;i++){
            prefixGcd[i]=gcd(nums[i],maxarr[i]);
        }
        Arrays.sort(prefixGcd);
        int i=0;
        int j=n-1;
        long ans=0;
        while(i<j){
            ans+=gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return ans;
        
    }
}