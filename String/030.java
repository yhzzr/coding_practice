public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    
        HashMap<String, Integer> set = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        if(words.length==0) 
            return res;
        
        int len = 0;
        int l = words[0].length();
        for(String w: words){
            set.put(w, set.containsKey(w)?set.get(w)+1:1);
            len += w.length();
        }
        for(int i=0;i<=s.length()-len;i++){
            Map<String, Integer> copy = new HashMap<String, Integer>(set);
            int p = 0;
            while(p<len){
                String sub = s.substring(i+p, i+p+l);
                if(copy.containsKey(sub)&&copy.get(sub)!= 0){
                    copy.put(sub, copy.get(sub)-1);
                    p+=l;
                    if(p==len){
                        res.add(i);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return res;
    }
}