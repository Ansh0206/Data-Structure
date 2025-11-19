class Solution {
    public boolean helper(int[][] matrix,int target,int row,int col){
        if(row>=matrix.length || col<0){
            return false;
        }
        if(matrix[row][col]==target){
            return true;
        }else if(matrix[row][col]<target){
            return helper(matrix,target,row+1,col);
        }else{
            return helper(matrix,target,row,col-1);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        return helper(matrix,target,row,col);
        
    }
}