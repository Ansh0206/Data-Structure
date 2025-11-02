class Solution {
    public int minSteps(String s, String t) {
        int[] sArr=new int[26];
        int[] tArr=new int[26];
        for(char ch : s.toCharArray()){
            sArr[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            tArr[ch-'a']++;
        }
        int count=0;
        for(int i=0;i<tArr.length;i++){
            if(tArr[i]==sArr[i]){
                continue;
            }
            if(tArr[i]<sArr[i]){
                count+=Math.abs(tArr[i]-sArr[i]);

            }
            
        }
        return count;
        
    }
}