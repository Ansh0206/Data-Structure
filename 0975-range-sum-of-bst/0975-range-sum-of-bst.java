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
    static int ans=0;
    public void helper(TreeNode root, int low, int high){
        if(root==null){
            return;
        }
        if(root.val>=low && root.val<=high){
            ans+=root.val;
        }
        helper(root.right,low,high);
        helper(root.left,low,high);

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans=0;
        helper(root,low,high);
        return ans;
        
        
    }
}