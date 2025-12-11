class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String curr=strs[i];
            char[] arr=curr.toCharArray();
            Arrays.sort(arr);

            String key=new String(arr);
            
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(curr);
        }
        return new ArrayList<>(map.values());
        
    }
}