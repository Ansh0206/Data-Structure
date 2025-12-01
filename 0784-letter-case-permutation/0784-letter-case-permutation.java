class Solution {
    public void helper(String s,StringBuilder sb,int i,List<String> ans){
        if(i==s.length()){
            ans.add(sb.toString());
            return;
        }
        char ch=s.charAt(i);
        if(ch>='0' && ch<='9'){
            helper(s,sb.append(ch),i+1,ans);
            sb.deleteCharAt(sb.length()-1);
        }else{
            helper(s,sb.append(Character.toUpperCase(ch)),i+1,ans);
            sb.deleteCharAt(sb.length()-1);
            helper(s,sb.append(Character.toLowerCase(ch)),i+1,ans);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        helper(s,new StringBuilder(),0,ans);
        return ans;
        
    }
}