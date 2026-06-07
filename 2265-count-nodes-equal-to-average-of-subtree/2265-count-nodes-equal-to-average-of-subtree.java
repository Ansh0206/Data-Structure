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
    static int count=0;
    public class Pair{
        int sum;
        int n;
        Pair(int sum,int n){
            this.sum=sum;
            this.n=n;
        }
    }
    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }

        Pair left=helper(root.left);
        Pair right=helper(root.right);
        int avg=(left.sum+right.sum+root.val)/(left.n+right.n+1);
        if(root.val==avg){
            count++;
        }
        return new Pair(left.sum+right.sum+root.val,left.n+right.n+1);

        
    }
    public int averageOfSubtree(TreeNode root) {
        count=0;
        helper(root);
        return count;
        
    }
}