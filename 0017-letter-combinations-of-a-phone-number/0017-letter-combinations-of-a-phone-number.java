class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void helper(String digits,String curr,int i,List<String> list){
        if(i==digits.length()){
            list.add(curr);
            return;
        }
        for(char ch : map[digits.charAt(i)-'0'].toCharArray()){
            helper(digits,curr+ch,i+1,list);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        helper(digits,"",0,list);
        return list;
        
    }
}