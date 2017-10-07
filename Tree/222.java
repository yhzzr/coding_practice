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
    public int countNodes(TreeNode root) {
        return count(root, 1);
    }
    
    private int count(TreeNode root, int index){
        if(root==null) return index/2;
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh==rh){
            while(rh>1){
                index = index*2+1;
                rh--;
            }
            return index;
        }else{
            int left = count(root.left, index*2);
            int right = count(root.right, index*2+1);
            return (left>right)?left:right;
        }
    }
    
    private int leftHeight(TreeNode root){
        if(root==null) return 0;
        else return 1+leftHeight(root.left);
    }
    private int rightHeight(TreeNode root){
        if(root==null) return 0;
        else return 1+rightHeight(root.right);
    }
}