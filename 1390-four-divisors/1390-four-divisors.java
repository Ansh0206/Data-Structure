class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int i : nums){
            int ans=0;
            int track=0;
            for(int j=1;j<=i;j++){
                if(track>4){
                    break;
                }
                if(i%j==0){
                    ans+=j;
                    track++;
                }
            }
            if(track==4){
                sum+=ans;
            }
        }
        return sum;
        
    }
}