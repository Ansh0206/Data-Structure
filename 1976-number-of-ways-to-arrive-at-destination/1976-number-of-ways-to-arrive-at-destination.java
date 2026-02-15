class Solution {
    static final long mod=(long)Math.pow(10,9)+7;
    public class Pair{
        int node;
        long dist;
        Pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        long[] ways=new long[n];
        ways[0]=1;
        long[] distance=new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.dist,b.dist));
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            long wt=curr.dist;

            if(wt>distance[u]){
                continue;
            }

            for(int i=0;i<adj.get(u).size();i++){
                Pair nbr=adj.get(u).get(i);
                int v=nbr.node;
                long costuv=nbr.dist;
                if(distance[v]>distance[u]+costuv){
                    distance[v]=distance[u]+costuv;
                    ways[v]=ways[u];
                    pq.offer(new Pair(v,distance[v]));
                }else if(distance[v]==distance[u]+costuv){
                    ways[v]=(ways[v]+ways[u])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}