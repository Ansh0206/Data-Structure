class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int i=0;
       
        while(i<rows){
            int left=0;
            int right=cols-1;
            while(left<=right){
                int mid=(left+right)/2;

                if(matrix[i][mid]==target){
                    return true;
                }
                if(matrix[i][mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            i++;
        }
        return false;
        
    }
}