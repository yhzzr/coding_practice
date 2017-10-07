/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String SEP = ",";
    private static final String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return NULL;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            root = st.pop();
            sb.append(root.val).append(SEP);
            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for(String e: strs){
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }
    
    private TreeNode getNode(Queue<Integer> q){
        if(q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> samllerQueue = new LinkedList<>();
        while(!q.isEmpty() && q.peek()<root.val){
            samllerQueue.offer(q.poll());
        }
        root.left = getNode(samllerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = getNode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));