/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public int size(ListNode head){
        int s=0;
        while(head!=null){
            head=head.next;
            s++;
        }
        return s;
    }
    public TreeNode helper(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,start,mid-1);
        root.right=helper(nums,mid+1,end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        int size=size(temp);
        int[] nums=new int[size];
        for(int i=0;i<nums.length;i++){
            nums[i]=temp.val;
            temp=temp.next;
        }
        return helper(nums,0,nums.length-1);
        
    }
}