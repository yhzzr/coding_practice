public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int head = 0;
        int tail = 0;
        int res = 0;
        while(tail<s.length()){
            char c = s.charAt(tail);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
            tail+=1;
            
            while(head<tail && map.size()>2){
                c = s.charAt(head);
                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c)-1);
                }
                head+=1;
            }
            if(tail-head> res)
                res = tail-head;
        }
        return res;
    }
}