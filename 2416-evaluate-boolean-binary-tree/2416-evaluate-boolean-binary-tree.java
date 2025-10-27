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
    public int helper(TreeNode root){
        if(root.left==null && root.right==null){
            return root.val;
        }
        int left=helper(root.left);
        int right=helper(root.right);

        if(root.val==2){
            if(left==0 && right==0){
                return 0;
            }else{
                return 1;
            }
        
        }else{
            if(left==0 || right==0){
                return 0;
            }else{
                return 1;
            }
        }
    }
    public boolean evaluateTree(TreeNode root) {
        if(root==null){
            return false;
        }
        int ans=helper(root);
        if(ans==0){
            return false;
        }
        return true;
        
    }
}