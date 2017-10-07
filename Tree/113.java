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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, sum);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> templist, TreeNode root, int sum){
        if(root==null){
            return;
        }
        templist.add(root.val);
        if(sum==root.val && root.left==null && root.right==null){
            res.add(new ArrayList(templist));
        }else{
                dfs(res, templist, root.left, sum-root.val);
                dfs(res, templist, root.right, sum-root.val);
        }
        templist.remove(templist.size()-1);
    }
}