class Solution {
    public boolean checkString(String s) {
        boolean yes=false;
        for(char ch : s.toCharArray()){
            if(ch=='b'){
                yes=true;
            }
            if(ch=='a' && yes){
                return false;
            }
        }
        return true;
        
    }
}