class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()==i-k){
                //element is  outdated
                //remove it from the first
                dq.removeFirst();
            }
            //remove the useless element from the last that cant be the part of being in competeion of the max
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }

            //add the current element,chances are there that it can be max in the future
            dq.addLast(i);
            if(i>=k-1){
                //window will start
                ans[i-k+1]=nums[dq.peekFirst()];

            }
            
        }
        return ans;
        
    }
}