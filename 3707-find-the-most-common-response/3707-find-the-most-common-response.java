class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> map=new HashMap<>();
        for(List<String> list : responses){
            Set<String> set=new HashSet<>();
            for(String str : list){
                set.add(str);
            }
            for(String str : set){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        String curr;
        String ans="";
        int i=0;
        for(String str : map.keySet()){
            if(i==0){
                ans=str;
                i++;
                continue;
            }
            curr=str;
            if(map.get(curr)>map.get(ans)){
                ans=str;
            }else if(map.get(curr)==map.get(ans)){
                if(ans.compareTo(curr)>0){
                    ans=str;
                }
            }
        }
        return ans;
        
        
    }
}