class Solution {
    public int secondHighest(String s) {
        int first=-1;
        int second=-1;
        for(char ch : s.toCharArray()){
            if(ch>='0' && ch<='9'){
                int n=ch-'0';
                if(n>first){
                    second=first;
                    first=n;
                }
                if(n<first && n>second){
                    second=n;
                }
            }
        }
        return second;
    }
}