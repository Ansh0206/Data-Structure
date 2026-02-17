class Solution {
    static int[] parent;
    static int[] rank;

    public int find(int x){
        if(parent[x]==x){
            return  x;
        }
        return parent[x]=find(parent[x]);
    }
    public boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv){   //cycle exist
           return false;
        }
        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }else{
            if(rank[pu]==rank[pv]){
                rank[pv]++;
            }
            parent[pu]=pv;
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int[] e : edges){
            if(!union(e[0],e[1])){
                return new int[]{e[0],e[1]};
            }
        }
        return new int[]{};


        
    }
}