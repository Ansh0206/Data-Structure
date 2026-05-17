class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public class Pair{
        int node;
        int dist;
        int stop;
        Pair(int node,int dist,int stop){
            this.node=node;
            this.dist=dist;
            this.stop=stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : flights){
            int u=arr[0];
            int v=arr[1];
            int d=arr[2];
            adj.get(u).add(new Pair(v,d,0));
        }
        int[][]distance=new int[n][k+2];
        for(int[] arr : distance){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        distance[src][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
        pq.offer(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            int dist=curr.dist;
            int stop=curr.stop;

            if(u==dst){
                return dist;
            }
            
            if(stop>k){
                continue;
            }
            for(int i=0;i<adj.get(u).size();i++){
                Pair nn=adj.get(u).get(i);
                int v=nn.node;
                int costuv=nn.dist;
                if(distance[v][stop+1]>dist+costuv){
                    distance[v][stop+1]=dist+costuv;
                    pq.offer(new Pair(v,distance[v][stop+1],stop+1));
                }

            }
        } 
        return -1;
    }
}