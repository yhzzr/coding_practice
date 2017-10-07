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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        
        encode(root, 0, 0, sb);
        sb.deleteCharAt(sb.length()-1);
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data=="") return root;
        
        String[] inputs = data.split("/");
        for(String input:inputs){
            String[] entry = input.split("#");
            int dir = Integer.parseInt(entry[0]);
            int level = Integer.parseInt(entry[1]);
            int value = Integer.parseInt(entry[2]);
            //System.out.println("Dir is "+dir+ " Level is "+level+" and value is "+value+" ");   
            
            root = decode(root, 0, level, dir, value);
        }
        
        return root;
    }
    
    public void encode(TreeNode root, int dir, int level, StringBuilder sb){
        if(root==null){
            String s = dir+"#"+level+"#"+"n"+"/";
            sb.insert(0, s);
        }else{
            if(root.left!=null)  encode(root.left,  1,level+1, sb);
            if(root.right!=null) encode(root.right, 2,level+1, sb);
            String s = dir + "#"+level+"#"+root.val+"/";
            sb.insert(0, s);
        }
    }
 
    public TreeNode decode(TreeNode root, int currentLevel, int targetLevel, int dir, int value){
        if(currentLevel==targetLevel){
            root = new TreeNode(value);
            return root;
        }else{
            if(currentLevel+1!=targetLevel){
                if(root.left==null){
                    root.right = decode(root.right, currentLevel+1, targetLevel, dir, value);
                }else{
                    root.left =  decode(root.left,  currentLevel+1, targetLevel, dir, value);
                }
            }else{
                if(dir==1){
                    root.left =  decode(root.left,  currentLevel+1, targetLevel, dir, value);
                }else if(dir==2){
                    root.right = decode(root.right, currentLevel+1, targetLevel, dir, value);
                }
            }
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));