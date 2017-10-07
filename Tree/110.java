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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int lh = depth(root.left);
        int rh = depth(root.right);
        
        if( Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
            
        return false;
    }
    
    private int depth(TreeNode root){
        if(root == null)
            return 0;
        else 
            return 1 + max(depth(root.right), depth(root.left));
    }
    
    private int max(int a, int b){
        return ( a < b) ? b : a;
    }
}