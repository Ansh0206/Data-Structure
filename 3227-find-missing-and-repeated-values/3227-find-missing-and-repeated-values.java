class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans=new int[2];
        int n=grid.length;
        int[] arr=new  int[(n*n)+1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[grid[i][j]]++;
            }
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                ans[0]=i;
            }
            if(arr[i]==0){
                ans[1]=i;
            }
        }
        return ans;


        
    }
}