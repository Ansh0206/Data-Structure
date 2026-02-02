class Solution {
    public boolean helper(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int src,int dest){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            int n=graph.get(src).get(i);
            if(!vis[n] && helper(graph,vis,n,dest)){
                return true;
            }
        }
        return  false;

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //creating the adjacency list first
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());

        }

        for(int[] arr : edges){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        boolean[] vis=new boolean[n];
        return helper(graph,vis,source,destination);
        
    }
}