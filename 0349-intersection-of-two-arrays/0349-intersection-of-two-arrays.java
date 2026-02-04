class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        for(int i : nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[] arr=new int[res.size()];
        int i=0;
        for(Integer in : res){
            arr[i++]=in;
        }
        return arr;

        
    }
}