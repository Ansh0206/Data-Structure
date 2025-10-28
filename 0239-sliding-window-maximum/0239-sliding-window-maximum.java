class Solution {
    public class Pair{
        int num;
        int index;
        Pair(int num,int index){
            this.num=num;
            this.index=index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> b.num-a.num);
        int i=0;
        int itr=0;
        for(;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        ans[itr++]=pq.peek().num;
        for(i=k;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
            while(pq.peek().index<=(i-k)){
                pq.remove();
            }
            ans[itr++]=pq.peek().num;
           
        }
        return ans;
        
    }
}