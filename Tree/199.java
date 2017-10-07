/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(res, root, 0);
        return res;
    }
    
    private void bfs(List<Integer> res, TreeNode root, int level){
        if(root==null) return;
        if(res.size()<=level){
            res.add(root.val); //check whether the level has been reached;
        }
        res.set(level, root.val);
        bfs(res, root.left, level+1);
        bfs(res, root.right, level+1);
    }
}