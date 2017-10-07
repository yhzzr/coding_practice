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
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 1, 1);
    }
    
    private int helper(TreeNode root, int max, int count){
        if(root==null) return max;
        int left, right;
        if(root.left!=null && root.left.val == root.val+1){
            left = helper(root.left, (max>count+1)?max:count+1, count+1);
        }else{
            left = helper(root.left, max, 1);
        }
        if(root.right!=null && root.right.val == root.val+1){
            right = helper(root.right, (max>count+1)?max:count+1, count+1);
        }else{
            right = helper(root.right, max, 1);
        }
        max = (max>left)?max:left;
        max = (max>right)?max:right;
        return max;
    }
}