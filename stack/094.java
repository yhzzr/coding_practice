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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashMap<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
        
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(map.containsKey(node)){
                list.add(node.val);
            }else{
                if(node.right != null) stack.push(node.right);
                stack.push(node);
                map.put(node, true);
                if(node.left != null) stack.push(node.left);
            }
        }
        return list;
    }
}