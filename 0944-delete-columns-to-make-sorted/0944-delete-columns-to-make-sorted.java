class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        char[][] grid=new char[n][strs[0].length()];
        int i=0;
        for(String str : strs){
            for(int index=0;index<str.length();index++){
                grid[i][index]=str.charAt(index);
            }
            i++;
        }
        int count=0;
        for(i=0;i<grid[0].length;i++){
            for(int j=1;j<grid.length;j++){
                if(grid[j][i]<grid[j-1][i]){
                    count++;
                    break;
                }
            }
        }
        return count;
        
    }
}