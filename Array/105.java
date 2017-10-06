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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, inorder.length-1, 0);
    }
    
    public TreeNode construct(int[] preorder, int[] inorder, int istart, int iend, int pi){
        if(pi > preorder.length-1 || istart>iend){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pi]);
        int index=0;
        for(int i=istart; i<=iend; i++){
            if(node.val == inorder[i]) {
                index=i;
            }
        }
        node.left =construct(preorder, inorder, istart,  index-1, pi+1);
        node.right=construct(preorder, inorder, index+1, iend,    pi+index-istart+1);
        return node;
    }
}