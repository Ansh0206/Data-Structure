class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        int last=Integer.MIN_VALUE;

        for(int i : nums){
            int min=Math.max(i-k,last+1);

            if(min<=i+k){
                set.add(min);
                last=min;
            }
        }
        return set.size();
        
    }
}