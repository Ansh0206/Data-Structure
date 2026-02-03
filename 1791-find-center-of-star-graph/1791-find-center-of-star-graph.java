class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int[] degree=new int[n+2];
        for(int i=0;i<edges.length;i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        for(int i=0;i<degree.length;i++){
            if(degree[i]==edges.length){
                return i;
            }
        }
        return -1;
        
    }
}