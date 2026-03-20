class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m=s.length();
        int k=p.length();
        if(k>m){
            return new ArrayList<>();
        }

        char[] arr=p.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder(new String(arr));
        String compare=sb.toString();      //compare the current window with this


        List<Integer> ans=new  ArrayList<>();
        StringBuilder window=new StringBuilder(s.substring(0,k));
        arr=window.toString().toCharArray();
        Arrays.sort(arr);
        StringBuilder sorted=new StringBuilder(new String(arr));
        if(compare.equals(sorted.toString())){
            ans.add(0);
        }
        for(int i=k;i<m;i++){
            window.deleteCharAt(0);
            window.append(s.charAt(i));
            arr=window.toString().toCharArray();
            Arrays.sort(arr);
            sorted=new StringBuilder(new String(arr));
            if(compare.equals(sorted.toString())){
                ans.add(i-k+1);
            }
        }
        return ans;
        
    }
}