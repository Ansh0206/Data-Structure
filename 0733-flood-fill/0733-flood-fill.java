class Solution {
    static int rowL;
    static int colL;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public void helper(int[][] image,boolean[][] vis,int row,int col,int color,int preColor){
        if(row<0 || row>=rowL || col<0 || col>=colL || image[row][col]!=preColor){
            return;
        }
        if(vis[row][col]){
            return;
        }
        preColor=image[row][col];
        vis[row][col]=true;
        image[row][col]=color;
        for(int i=0;i<=3;i++){
            helper(image,vis,row+dr[i],col+dc[i],color,preColor);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rowL=image.length;
        colL=image[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int prev=image[sr][sc];
        for(int i=sr;i<rowL;i++){
            for(int j=sc;j<colL;j++){
                helper(image,vis,i,j,color,image[sr][sc]);
            }
        }
        return image;
        
    }
}