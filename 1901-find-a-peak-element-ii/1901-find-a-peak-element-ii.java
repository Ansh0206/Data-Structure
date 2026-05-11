class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxi = -(int)1e9;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] > maxi){
                    maxi = mat[i][j];
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] > maxi){
                    maxi = mat[i][j];
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == maxi){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}