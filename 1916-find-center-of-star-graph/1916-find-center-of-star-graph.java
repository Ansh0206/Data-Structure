class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] arr : edges){
            map.put(arr[0],map.getOrDefault(arr[0],0)+1);
            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
        }
        int n=edges.length;
        for(Integer key : map.keySet()){
            if(map.get(key)==n){
                return key;
            }
        }
        return -1;
        
    }
}