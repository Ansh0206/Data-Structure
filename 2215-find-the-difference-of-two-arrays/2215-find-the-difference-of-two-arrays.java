class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res=new ArrayList<>();
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

        for(int i : nums1){
            s1.add(i);
        }
        for(int i : nums2){
            s2.add(i);
        }
        for(int i : nums1){
            if(s2.contains(i)){
                s2.remove(i);
            }
        }
        for(int i : nums2){
            if(s1.contains(i)){
                s1.remove(i);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(Integer num : s1){
            list.add(num);
        }
        res.add(new ArrayList<>(list));
        list.clear();
        for(Integer num : s2){
            list.add(num);
        }
        res.add(list);
        return res;
        
    }
}