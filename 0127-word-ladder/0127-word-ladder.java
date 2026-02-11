class Solution {
    public class Pair{
        String s;
        int level;
        Pair(String s,int level){
            this.s=s;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        set.remove(beginWord);
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String st=curr.s;
            int l=curr.level;
            if(st.equals(endWord)){
                return l;
            }
            for(int i=0;i<st.length();i++){
                char[] arr=st.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    if(arr[i]==ch){
                        continue;
                    }
                    arr[i]=ch;
                    String replaceWord=new String(arr);
                    if(set.contains(replaceWord)){
                        q.offer(new Pair(replaceWord,l+1));
                        set.remove(replaceWord);
                    }
                }
            }
        }
        return 0;
    }
}