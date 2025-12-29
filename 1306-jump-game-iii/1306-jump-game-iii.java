class Solution {
    public boolean helper(int[] arr,int start,boolean[] vis){
        if(start<0 || start>=arr.length){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        if(vis[start]!=false){
            return false;
        }
        vis[start]=true;
        boolean left=helper(arr,start-arr[start],vis);
        boolean right=helper(arr,start+arr[start],vis);
        vis[start]=false;
        return left || right;
    }
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0){
            return true;
        }
        boolean[] vis=new boolean[arr.length];
        return helper(arr,start,vis);
        
    }
}