class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] in=new int[n+1];
        int[] out=new int[n+1];
        for(int[] arr : trust){
            in[arr[1]]++;
            out[arr[0]]++;
        }
        for(int i=0;i<in.length;i++){
            if(in[i]==n-1 && out[i]==0){
                return i;
            }
        }
        return -1;

        
        
    }
}