class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String str : details){
            if(str.charAt(11)-'0'==6 && str.charAt(12)-'0'==0){
                continue;
            }
            if(str.charAt(11)-'0'>=6 && str.charAt(12)-'0'>=0){
                count++;
            }
        }
        return count;
        
    }
}