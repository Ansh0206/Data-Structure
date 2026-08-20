class Solution {
    public class Pair{
        int key;
        int val;
        Pair(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Pair> list=new ArrayList<>();
        for(Integer  key : map.keySet()){
            list.add(new Pair(key,map.get(key)));
        }
        Collections.sort(list,(a,b)->{
            if(a.val!=b.val){
                return Integer.compare(a.val,b.val);
            }
            return Integer.compare(b.key,a.key);
        });
        
        int[] ans=new int[nums.length];
        int idx=0;
        for(int i=0;i<list.size();i++){
            Pair curr=list.get(i);
            int key=curr.key;
            int val=curr.val;
            while(val>0){
                ans[idx++]=key;
                val--;
            }

        }
        return ans;
    }
}