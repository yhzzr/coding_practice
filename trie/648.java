class Solution {
    
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            isWord = false;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        
        TrieNode root = new TrieNode();
        
        //put everything into the trie
        for(String s:dict){
            TrieNode node = root;
            for(int i=0;i<s.length();i++){
                int index = s.charAt(i)-'a';
                if(node.children[index]==null)
                    node.children[index]=new TrieNode();
                node = node.children[index];
            }
            node.isWord = true;
        }
        
        String[] inputs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s: inputs){
            int index = search(root, s);
            //System.out.println("s is "+s+" and index is " + index);
            if(index==-1) sb.append(s);
            else sb.append(s.substring(0,index+1));
            sb.append(" ");
        }
        
        return sb.substring(0, sb.length()-1);
    }
    
    public int search(TrieNode root, String s){
        TrieNode node = root;
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(node.children[index]==null) return -1;
            else{
                if(node.children[index].isWord) return i;
                else node = node.children[index];
            }
        }
        return -1;
    }
}