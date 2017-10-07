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
    
    int res=-1;
    
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        helper(root,root.val);
        return res;
    }
    
    public int helper(TreeNode root, int val){
        if(root==null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        res = Math.max(left+right,res);
        if(root.val == val){
            return 1+Math.max(left,right);
        }else{
            return 0;
        }
    }
}