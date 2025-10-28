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
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode helper(ArrayList<Integer> list,int i){
        if(i==list.size()){
            return null;
        }
        TreeNode root=new TreeNode(list.get(i));
        root.right=helper(list,i+1);

        return root;

    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        return helper(list,0);

        
    }
}