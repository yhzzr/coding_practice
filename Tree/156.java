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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root;
        TreeNode newMiddle = new TreeNode(root.val);
        return action(root.left, newMiddle , root.right);
    }
    
    private TreeNode action(TreeNode leftNode, TreeNode middleNode, TreeNode rightNode){
        if(leftNode.left == null){
            TreeNode newRoot = new TreeNode(leftNode.val);
            newRoot.right = middleNode;
            newRoot.left  = rightNode;
            return newRoot;
        }else{
            TreeNode newMiddle = new TreeNode(leftNode.val);
            newMiddle.right = middleNode;
            newMiddle.left = rightNode;
            return action(leftNode.left, newMiddle, leftNode.right);
        }
    }
}