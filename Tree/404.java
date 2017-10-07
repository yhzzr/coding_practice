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
    
    int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root){
        helper(root);
        return sum;
    }
    public void helper(TreeNode root) {
        if(root==null) return;
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null) sum = sum+root.left.val;
            else sumOfLeftLeaves(root.left);
        }
        sumOfLeftLeaves(root.right);
    }
}