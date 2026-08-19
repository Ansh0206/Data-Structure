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
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> q=new LinkedList<>();
        boolean left=true;
        q.offerLast(root);

        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode curr;
                if(left){
                    curr=q.pollFirst();
                    list.add(curr.val);
                    if(curr.left!=null){
                        q.offerLast(curr.left);
                    }
                    if(curr.right!=null){
                        q.offerLast(curr.right);
                    }
                }else{
                     curr=q.pollLast();
                    list.add(curr.val);
                    
                    if(curr.right!=null){
                        q.offerFirst(curr.right);
                    }
                    if(curr.left!=null){
                        q.offerFirst(curr.left);
                    }
                }
            }
            ans.add(list);
            left=!left;
        }
        return ans;
    }
}