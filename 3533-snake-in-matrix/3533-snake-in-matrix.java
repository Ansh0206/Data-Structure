class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row=0;
        int col=0;
        for(String str : commands){
            if(str.equals("RIGHT")){
                col++;
            }else if(str.equals("LEFT")){
                col--;
            }else if(str.equals("UP")){
                row--;
            }else{
                row++;
            }
        }
        int ans=(n)*(row)+col;
        return ans;
        
    }
}