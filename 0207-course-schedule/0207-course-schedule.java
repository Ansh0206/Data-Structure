class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        ArrayList<Integer> res=new ArrayList<>();
        int[] in=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            in[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.offer(i);
                res.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<list.get(curr).size();i++){
                int el=list.get(curr).get(i);
                in[el]--;
                if(in[el]==0){
                    q.add(el);
                    res.add(el);
                }  
            }
        }
        if(res.size()==numCourses){
            return true;
        }
        return false;
        
    }
}