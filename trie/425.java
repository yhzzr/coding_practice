public class Solution {
    private class TrieNode{
        List<String> list;
        TrieNode[] children;
        TrieNode(){
            list = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        for (String word: words){
            root.list.add(word);
            TrieNode cur = root;
            for (char ch: word.toCharArray()){
                if (cur.children[ch - 'a'] == null){
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
                cur.list.add(word);
            }
        }
        int len = words[0].length();
        TrieNode[] tns = new TrieNode[len];
        Arrays.fill(tns, root);
        dfs(0, new char[len][len], result, tns);
        return result;
    }
    
    void dfs(int idx, char[][] arr, List<List<String>> ans, TrieNode[] tns) {
        if (idx == arr.length){
            List<String> ws = new ArrayList<>();  
            for (char[] chArr: arr){
                ws.add(new String(chArr));
            }
            ans.add(ws);
            return;
        }
        TrieNode[] tns2 = new TrieNode[tns.length];
        for (String cand : tns[idx].list) {
            int i = idx;
            while (i < arr.length) {
                char ch = cand.charAt(i);
                arr[idx][i] = ch;
                if (i > idx) {
                    arr[i][idx] = ch; 
                    if (tns[i].children[ch - 'a'] == null) break; 
                    tns2[i] = tns[i].children[ch - 'a'];
                }
                i++;
            }
            if (i == arr.length){
                dfs(idx + 1, arr, ans, tns2);
            }
        }
    }
    
    
}