class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> map=new HashMap<>();
        char ch='a';
        for(int i=0;i<key.length();i++){
            if(ch>'z'){
                break;
            }
            char curr=key.charAt(i);
            if(curr==' '){
                continue;
            }
            if(map.containsKey(curr)){
                continue;
            }
            map.put(curr,ch++);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<message.length();i++){
            char curr=message.charAt(i);
            if(curr==' '){
                sb.append(' ');
            
            }else{
                sb.append(map.get(curr));
            }
        }
        return sb.toString();
        
    }
}