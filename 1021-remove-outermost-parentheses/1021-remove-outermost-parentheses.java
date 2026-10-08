class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length()==0 || s.length()==1){
            return "";
        } 
        StringBuilder sb=new StringBuilder();
        int open=0;
        int track=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            sb.append(ch);
            if(ch=='('){
                open++;
            }else{
                open--;
            }
            if(open==0){
                sb.deleteCharAt(track);
                sb.deleteCharAt(sb.length()-1);
                track=sb.length()+1;
                
            }
        }
        return sb.toString();
        
    }
}