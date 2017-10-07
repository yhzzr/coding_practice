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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null) return -1;
        int r=root.right.val, l=root.left.val;
        if(r == root.val) r = findSecondMinimumValue(root.right);
        if(l == root.val) l = findSecondMinimumValue(root.left);
        if(r == -1 && l == -1) return -1;
        if(r != -1 && l != -1) return Math.min(r,l);
        if(r == -1) return l;
        return r;
    }
}