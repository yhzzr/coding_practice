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
    
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int inc=1, dec=1;
        if(root.left!=null){
            int[] l = helper(root.left);
            if(root.val-root.left.val==1){
                dec = l[1]+1;
            }else if(root.val-root.left.val==-1){
                inc = l[0]+1;
            }
        }
        if(root.right !=null){
            int[] r = helper(root.right);
            if(root.val-root.right.val==1){
                dec = Math.max(dec, r[1]+1);
            }else if(root.val-root.right.val==-1){
                inc = Math.max(inc, r[0]+1);
            }
        }
        max = Math.max(max, inc+dec-1);
        return new int[]{inc, dec};
    }
}