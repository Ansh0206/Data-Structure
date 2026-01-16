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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int max=Integer.MIN_VALUE;
        int level=1;
        int ans=0;
        int curr=1;
        while(!q.isEmpty()){
            TreeNode top=q.remove();
            if(top==null){
                if(ans>max){
                    max=ans;
                    level=curr;
                    
                }
                if(!q.isEmpty()){
                    q.add(null);
                }
                ans=0;
                curr++;
            }
            else{
                ans+=top.val;
                if(top.left!=null){
                    q.add(top.left);
                }
                if(top.right!=null){
                    q.add(top.right);
                }
            }
        }
        return level;
        
    }
}