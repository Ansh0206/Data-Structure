class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int count=0;
        int k=3;

        for(int i=0;i<k;i++){
            sb.append(s.charAt(i));
        }
        if(sb.charAt(0)!=sb.charAt(1) &&  sb.charAt(0)!=sb.charAt(2) && sb.charAt(1)!=sb.charAt(2)){
            //all unique
            count++;
        }

        //slide the window
        for(int i=k;i<s.length();i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));

            //checking
            if(sb.charAt(0)!=sb.charAt(1) && sb.charAt(0)!=sb.charAt(2) && sb.charAt(1)!=sb.charAt(2)){
                count++;
            }

        }
        return count;
        
    }
}