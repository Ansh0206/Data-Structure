class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans=new int[2];
        Set<Integer> set=new HashSet<>();
        for(int[] arr : grid){
            for(int i=0;i<arr.length;i++){
                if(!set.contains(arr[i])){
                    set.add(arr[i]);

                }else if(set.contains(arr[i])){
                    ans[0]=arr[i];
                }
            }
        }
        for(int i=1;i<=grid.length*grid.length;i++){
            if(!set.contains(i)){
                ans[1]=i;
                break;
            }
        }
        return ans;
        
    }
}