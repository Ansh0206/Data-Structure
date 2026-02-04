class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr1=new int[1001];
        int[] arr2=new int[1001];
       
        for(int i=0;i<nums1.length;i++){
            int curr=nums1[i];
            arr1[curr]++;
        }
        for(int i=0;i<nums2.length;i++){
            int curr=nums2[i];
            arr2[curr]++;
        }
        int len=0;
        for(int i=0;i<arr1.length;i++){
            len+=Math.min(arr1[i],arr2[i]);
           
        }
        int[] res=new int[len];
        int index=0;
        for(int i=0;i<arr1.length;i++){
            int min=Math.min(arr1[i],arr2[i]);
            for(int j=0;j<min;j++){
                res[index++]=i;
            }
           
        }
        return res;
        
    }
}