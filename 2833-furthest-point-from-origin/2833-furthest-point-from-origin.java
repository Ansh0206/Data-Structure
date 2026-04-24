class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dist=0;
        int l=0;
        int r=0;
        for(char ch : moves.toCharArray()){
            if(ch=='L'){
                l++;
            }else if(ch=='R'){
                r++;
            }
        }

        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='L'){
                dist--;
            }else if(ch=='R'){
                dist++;
            }else{
                if(l>r){
                    dist--;
                }else{
                    dist++;
                }
            }
        }
        return Math.abs(dist);
        
    }
}