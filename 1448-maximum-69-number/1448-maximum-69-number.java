class Solution {
    public int maximum69Number (int num) {
        String s=String.valueOf(num);
        StringBuilder sb=new StringBuilder();
        boolean done=true;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='6' && done){
                sb.append('9');
                done=false;
            }else{
                sb.append(ch);
            }
        }
        String ans=sb.toString();
        return Integer.valueOf(ans);
        
    }
}