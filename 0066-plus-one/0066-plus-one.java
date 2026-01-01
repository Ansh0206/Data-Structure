class Solution {
    public void helper(int[] arr,int i,int carry){
        if(i<0 || carry==0){
            return;
        }
        if(arr[i]==9){
            arr[i]=0;
            helper(arr,i-1,1);
        }else{
            arr[i]=arr[i]+1;
            helper(arr,i-1,0);
        }
    }
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        helper(digits,n-1,1);
        if(digits[0]==0){
            int[] res=new int[n+1];
            res[0]=1;
            return res;
        }
        return digits;
        
    }
}