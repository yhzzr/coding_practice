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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(postorder, inorder, 0, inorder.length-1, inorder.length-1);
    }
    
    public TreeNode construct(int[] postorder, int[] inorder, int istart, int iend, int pi){
        if(pi < 0 || istart>iend){
            return null;
        }
        TreeNode node = new TreeNode(postorder[pi]);
        int index=0;
        for(int i=istart; i<=iend; i++){
            if(node.val == inorder[i]) {
                index=i;
            }
        }
        node.left =construct(postorder, inorder, istart,  index-1, pi-(iend-index)-1);
        node.right=construct(postorder, inorder, index+1, iend,    pi-1);
        return node;
    }
}