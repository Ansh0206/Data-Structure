class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> star =new Stack<>();

        for(int i=0; i<s.length(); i++){

            char ch=s.charAt(i);
            if(ch =='('){
                st.push(i);
            }
            else if(ch=='*'){
                star.push(i);
            }
            else{
                if(!st.empty() ){
                    st.pop();
                }

                else if( !star.empty()){
                    star.pop();
                }
                else return false;
            }
        }

        while(!st.empty() && !star.empty()){
            if(st.pop() > star.pop()) return false;
        }

        return st.empty();
    }
}