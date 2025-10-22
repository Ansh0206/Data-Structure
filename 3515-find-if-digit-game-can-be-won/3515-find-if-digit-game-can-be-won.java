class Solution {
    public boolean canAliceWin(int[] nums) {
        int single=0;
        int two=0;
        for(int i : nums){
            String s=String.valueOf(i);
            if(s.length()==1){
                single+=i;
            }else{
                two+=i;

            }
        }
        if(single==two){
            return false;
        }
        return true;
        
    }
}