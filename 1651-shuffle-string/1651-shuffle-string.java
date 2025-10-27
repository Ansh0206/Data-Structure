class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int index=indices[i];
            sb.setCharAt(index,ch);
        }
        return sb.toString();
        
    }
}