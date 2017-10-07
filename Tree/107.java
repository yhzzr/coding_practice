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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        
        List<TreeNode> queue = new ArrayList();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove(0);
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(0,list);
        }
        return result;
    }
}