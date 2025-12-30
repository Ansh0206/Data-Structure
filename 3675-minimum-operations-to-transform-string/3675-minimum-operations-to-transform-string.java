class Solution {
    public int minOperations(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='a'){
                return 0;
            }else{
                return 26-(s.charAt(0)-'a');
            }
        }
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length-1;i++){
            char curr=arr[i];
            if(curr=='a'){
                continue;
            }
            while(curr!=arr[i+1]){
                curr++;
                count++;
            }
        }
        if(count==0 && arr[arr.length-1]=='a'){
            return 0;
        }
        count+=26-(arr[arr.length-1]-'a');
        return count;
        
    }
}