class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", 0, 0, n);
        return res;
    }

    public void generate(String curr, int open, int close, int n){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }

        if(open<n){
            curr+='(';
            generate(curr, open+1, close, n);
            curr = curr.substring(0, curr.length()-1);
        }
        if(close<open){
            curr+=')';
            generate(curr, open, close+1, n);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}