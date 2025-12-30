class Solution {
    public int minOperations(String s) {
        int min=-1;
        for(int i=0;i<s.length();i++){
            int curr=(26-(s.charAt(i)-'a'))%26;
            min=Math.max(min,curr);
        }
        return min;
        
    }
}