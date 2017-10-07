public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        int length = strs[0].length();
        int index = 0;
        for(int i=1; i< strs.length; i++){
            if( strs[i].length() < length ) {
                length = strs[i].length();
                index = i;
            }
        }
        for(int i=0; i< length; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
               if( c != strs[j].charAt(i)) 
                return strs[0].substring(0, i); 
            }
        }
        return strs[index];
    }
}