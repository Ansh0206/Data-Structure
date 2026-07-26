class Solution {
    public int uniquePaths(int m, int n) {
        int[] curr=new int[n];
        int[] prev=new int[n];
        curr[0]=1;
        Arrays.fill(prev,1);

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int top=prev[j];
                int left=curr[j-1];

                curr[j]=top+left;


            }
            prev=curr;
        }
        return prev[n-1];
    }
}