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
    int total = 0;
    
    public int findTilt(TreeNode root) {
        helper(root);
        return total;
    }
    
    private int helper(TreeNode root){
        if(root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        total += Math.abs(left-right);
        return left+right+root.val;
    }
    
    
}