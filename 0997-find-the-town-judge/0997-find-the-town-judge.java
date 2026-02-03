class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] arr=new int[n+1];
        for(int[] ar : trust){
            arr[ar[1]]++;
            arr[ar[0]]--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n-1){
                return i;
            }
        }
        return -1;

        
        
    }
}