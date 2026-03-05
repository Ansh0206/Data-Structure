class Solution {
    public int minOperations(String s) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        int one=0;
        int two=0;

        for(int i=1;i<=s.length();i++){
            if(i%2==0){
                sb1.append('0');
                sb2.append('1');
            }else{
                sb1.append('1');
                sb2.append('0');
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=sb1.charAt(i)){
                one++;
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=sb2.charAt(i)){
                two++;
            }
        }
        return Math.min(one,two);

        
    }
}