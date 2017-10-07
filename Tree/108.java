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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return build(nums, 0, nums.length-1);
    }
    
    private TreeNode build(int[] nums, int lo, int hi){
        int mid = lo + (hi-lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if( lo == hi) {
            return root;
        }else{
            if( lo <= mid-1 && mid-1 >= 0)
                root.left = build(nums, lo, mid-1);
            if( mid+1 <= hi && mid+1 < nums.length )
                root.right = build(nums, mid+1, hi);
            return root;
        }
    }
}