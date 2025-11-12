class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(s.length()!=words.size()){
            return false;
        }
        int itr=0;
        for(String str : words){
            if(s.charAt(itr)!=str.charAt(0)){
                return false;
            }
            itr++;
        }
        return true;
    }
}