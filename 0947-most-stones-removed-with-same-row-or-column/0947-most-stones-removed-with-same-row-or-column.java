class Solution {
    static int[] parent;
    static int[] rank;
    static int component;
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(py==px){
            return false;
        }
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else{
            if(rank[px]==rank[py]){
                rank[py]++;
            }
            parent[px]=py;
        }
        component--;
        return true;
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        component=n;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((stones[i][0]==stones[j][0]) || (stones[i][1]==stones[j][1])){
                    union(i,j);
                }
            }
        }
        return n-component;
      
        
    }
}