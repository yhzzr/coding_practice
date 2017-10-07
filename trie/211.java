class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class WordDictionary {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null){
                ws.children[c-'a'] = new TrieNode(c);
            }
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word);
    }
    
    private boolean helper(TrieNode root, String word){
        if(word.length()==0) 
            return root.isWord;
        boolean res = false;
        char c = word.charAt(0);
        if(c =='.'){
            for(int i=0;i<26;++i){
                if(root.children[i]!=null){
                    res = res || helper(root.children[i], word.substring(1));
                }
            }
        }else if(root.children[c-'a']!=null){
            res = helper(root.children[c-'a'], word.substring(1));    
        }
        return res;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */