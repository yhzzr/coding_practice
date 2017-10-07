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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }
    
    public TreeNode build(int[] nums, int l, int r){
        if(l>r){
            return null;
        }else{
            int max = Integer.MIN_VALUE;
            int index = l;
            for(int i=l;i<=r;i++){
               if(nums[i]>max){
                   max = nums[i];
                   index = i;
               } 
            }
            TreeNode node = new TreeNode(nums[index]);
            node.left = build(nums, l, index-1);
            node.right = build(nums, index+1, r);
            return node;
        }
        
    }
}