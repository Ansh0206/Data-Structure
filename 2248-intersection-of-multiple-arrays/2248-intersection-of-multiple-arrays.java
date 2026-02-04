class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list=new ArrayList<>();
        int[] arr=new int[1001];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                int curr=nums[i][j];
                arr[curr]++;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==nums.length){
                list.add(i);
            }
        }
        return list;
        
    }
}