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
    public class Pair{
        TreeNode node;
        int row;
        int col;
        Pair(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));   
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> {
            if (a.col != b.col)
            return a.col - b.col;

        if (a.row != b.row)
            return a.row - b.row;

        return a.node.val - b.node.val;
        });
        while(!q.isEmpty()){
            Pair curr=q.poll();
            TreeNode node=curr.node;
            int row=curr.row;
            int col=curr.col;
            pq.add(new Pair(node,row,col));
            if(node.left!=null){
                q.add(new Pair(node.left,row+1,col-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,row+1,col+1));
            }
        }
        while(!pq.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            Pair curr=pq.poll();
            int dist=curr.col;
            list.add(curr.node.val);
            while(pq.peek()!=null && pq.peek().col==dist){
                list.add(pq.peek().node.val);
                pq.poll();
            }
            ans.add(list);
        }
        return ans;

        
    }
}