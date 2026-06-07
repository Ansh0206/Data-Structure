class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int r=n/3;
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Integer key : map.keySet()){
            if(map.get(key)>r){
                list.add(key);
            }
        }
        return list;
        
    }
}