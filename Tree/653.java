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
    
    boolean res = false;
    
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        traverse(root, k, set);
        return res; 
    }
    
    public void traverse(TreeNode root, int k, HashSet<Integer> set){
        if(root==null)
            return;
        int key = root.val;
        if(set.contains(key)){
            res = true;
            return;
        }else{
            set.add(k-key);
            traverse(root.left, k, set);
            traverse(root.right, k, set);
        }
    }
}