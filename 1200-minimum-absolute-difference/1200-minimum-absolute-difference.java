class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(arr);
        //first find the min absolute diiference
        int min=Math.abs(arr[0]-arr[1]);
        for(int i=1;i<arr.length-1;i++){
            min=Math.min(min,Math.abs(arr[i]-arr[i+1]));

        }
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1])==min){
                List<Integer> ll=new ArrayList<>();
                ll.add(arr[i]);
                ll.add(arr[i+1]);
                list.add(ll);
            }
        }
        return list;
        
    }
}