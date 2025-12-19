class Solution {
    public int countKeyChanges(String s) {
        int count=0;
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            char prev=s.charAt(i-1);
            if(Character.toLowerCase(curr)!=Character.toLowerCase(prev)){
                count++;
            }
        }
        return count;
        
    }
}