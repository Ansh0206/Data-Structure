class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int last=Integer.MIN_VALUE;
        int count=0;

        for(int i : nums){
            int min=Math.max(i-k,last+1);

            if(min<=i+k){
                count++;
                last=min;
            }
        }
        return count;
        
    }
}