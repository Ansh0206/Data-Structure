class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len=rooms.size();
        boolean[] vis=new boolean[len];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int remove=q.poll();
            vis[remove]=true;
            for(int i=0;i<rooms.get(remove).size();i++){
                int n=rooms.get(remove).get(i);
                if(!vis[n]){
                    q.add(n);
                    vis[n]=true;
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
        
    }
}