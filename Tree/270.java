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
    public int closestValue(TreeNode root, double target) {
        return (int) (target - minDiff(root, target));
    }
    
    private double minDiff(TreeNode root, double target){
        double diff = target - root.val;
        if(root.left == null && root.right == null) 
            return diff;
        else if(root.left == null && root.right != null) 
            return ( Math.abs( minDiff(root.right, target)) < Math.abs(diff) ) ? minDiff(root.right, target) : diff ;
        else if(root.left != null && root.right == null)
            return ( Math.abs( minDiff(root.left, target)) < Math.abs(diff) ) ? minDiff(root.left, target) : diff ;
        else{
            double diff1 = minDiff(root.left, target);
            double diff2 = minDiff(root.right, target);
            double diff_com = (Math.abs(diff1) < Math.abs(diff2)) ? diff1 : diff2;
            return (Math.abs(diff) < Math.abs(diff_com)) ? diff : diff_com;
        }
    }
}