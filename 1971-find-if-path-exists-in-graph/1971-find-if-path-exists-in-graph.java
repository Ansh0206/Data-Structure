class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i =0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int first=edges[i][0];
            int second=edges[i][1];
            list.get(first).add(second);
            list.get(second).add(first);
        }
        boolean[] vis=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(source);
        while(!q.isEmpty()){
            int remove=q.poll();
            vis[remove]=true;
            for(int i=0;i<list.get(remove).size();i++){
                int nn=list.get(remove).get(i);
                if(!vis[nn]){
                    q.offer(nn);
                    vis[nn]=true;
                }
            }

        }
        if(vis[destination]){
            return true;
        }
        return false;
        
    }
}