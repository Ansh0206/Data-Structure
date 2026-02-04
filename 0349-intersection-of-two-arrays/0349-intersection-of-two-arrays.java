class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr=new int[1001];
        boolean[] arr1=new boolean[1001];
        boolean[] arr2=new boolean[1001];
        for(int i=0;i<nums1.length;i++){
            int curr=nums1[i];
            if(!arr1[curr]){
                arr[curr]++;
                arr1[curr]=true;
            }
        }
        for(int i=0;i<nums2.length;i++){
            int curr=nums2[i];
            if(!arr2[curr]){
                arr[curr]++;
                arr2[curr]=true;
            }
        }
        int len=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                len++;
            }
        }
        int[] res=new int[len];
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]==2){
                res[i++]=j;
            }
        }
        return res;
    }
}