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
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        String res = build(t);
        return res.substring(1,res.length()-1);
    }
    
    public String build(TreeNode root){
        String res = "("+root.val;
        if(root.left==null){
            if(root.right==null){
                res = res+")";
            }else{
                String right = build(root.right);
                res = res+"()"+right+")";
            }
        }else{
            String left = build(root.left);
            if(root.right!=null){
                String right = build(root.right);
                res = res+left+right+")";
            }else{
                res = res+left+")";
            }
        }
        return res;
    }
}