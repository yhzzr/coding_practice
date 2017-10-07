class MapSum {
    
    class TrieNode{
        TrieNode[] children;
        int val;
        boolean isWord;
        
        public TrieNode(int val){
            children = new TrieNode[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            this.val = val;
            isWord = false;
        }
    }

    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode(0);
    }
    
    public void insert(String key, int val) {
        int n = key.length();
        TrieNode node = root;
        for(int i=0;i<n;i++){
            int index = key.charAt(i)-'a';
            if(node.children[index]==null)
                node.children[index] = new TrieNode(val);
            node = node.children[index];
        }
        node.val = val;
        node.isWord=true;
    }
    
    public int sum(String prefix) {
        TrieNode node = search(prefix);
        return helper(node);
    }
    
    public int helper(TrieNode node){
        if(node==null){
            return 0;
        }
        int total = (node.isWord)?node.val:0;
        for(TrieNode n:node.children){
            total += helper(n);
        }
        return total;
    }
    
    public TrieNode search(String prefix){
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(node.children[index]==null) return null;
            else node = node.children[index];
        }
        return node;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */