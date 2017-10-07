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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode newroot = null;
        newroot = traverse(root, newroot, L, R);
        return newroot;
    }
    
    public TreeNode build(TreeNode root, int val){
        if(root==null){
            root = new TreeNode(val);
            return root;
        }
        if(val<=root.val){
            root.left = build(root.left, val);
        }else{
            root.right = build(root.right, val);
        }
        return root;
    }
    
    public TreeNode traverse(TreeNode node, TreeNode newroot, int L, int R){
        if(node==null) return newroot;
        if(node.val>R){
            newroot = traverse(node.left, newroot, L, R);
        }else if(node.val<L){
            newroot = traverse(node.right, newroot, L, R);
        }else{
            newroot = build(newroot, node.val);
            newroot = traverse(node.left, newroot, L,R);
            newroot = traverse(node.right, newroot, L, R);
        }
        return newroot;
    }
}