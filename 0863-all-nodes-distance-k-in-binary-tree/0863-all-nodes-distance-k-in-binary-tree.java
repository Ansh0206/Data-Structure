/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void buildParentMap(TreeNode node,TreeNode parent,Map<TreeNode,TreeNode> map){
        if(node==null){
            return;
        }
        map.put(node,parent);
        buildParentMap(node.left,node,map);
        buildParentMap(node.right,node,map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        buildParentMap(root,null,map);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        Set<TreeNode> vis=new HashSet<>();
        int dist=0;
        vis.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(dist==k){
                break;
            }
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !vis.contains(curr.left)){
                    q.add(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    q.add(curr.right);
                    vis.add(curr.right);
                }

                TreeNode parent=map.get(curr);
                if(parent!=null && !vis.contains(parent)){
                    vis.add(parent);
                    q.offer(parent);
                }
            }
            dist++;

        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    }
}