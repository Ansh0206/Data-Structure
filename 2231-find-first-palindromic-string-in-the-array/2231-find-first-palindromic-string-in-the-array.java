class Solution {
    public boolean isPalindrome(String str){
        int first=0;
        int last=str.length()-1;
        while(first<last){
            if(str.charAt(first)!=str.charAt(last)){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String str : words){
            boolean yes=isPalindrome(str);
            if(yes){
                return str;
            }
        }
        return "";
        
    }
}