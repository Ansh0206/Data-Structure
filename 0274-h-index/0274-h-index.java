class Solution {
    public int hIndex(int[] citations) {

        int[] arr=new int[citations.length];
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(citations[j]>=i+1){
                    count++;
                }
            }
            if(count>=i+1){
                arr[i]=i+1;
            }else{
                arr[i]=0;
                
            }
            
            
        }
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i+1){
                max=Math.max(max,arr[i]);
            }
        }
        return max;
            
    }
}