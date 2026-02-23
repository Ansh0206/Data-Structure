/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        boolean track=true;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            List<Integer> l=new ArrayList<>();
            while(q.peek()!=null){
                TreeNode curr=q.poll();
                l.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(track){    //track==positive  means have travel left to right else right to left
                list.add(new ArrayList<>(l));
            }else{
                list.add(new ArrayList<>(l));
                Collections.reverse(list.get(list.size()-1));
            }
            if(q.poll()==null && q.isEmpty()){
                break;
            }
            q.add(null);
            track=!track;

        }
        return list;

        
    }
}