public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        int length = s.length();
        
        if( length == 0) return false;
        
        boolean[] result = new boolean[length+1];
        result[0] = true;
        
        for(int i=1; i <= length; i++){
            for(int j=0; j<i; j++){
                if( result[j] && wordDict.contains(s.substring(j,i) ) ){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[length];
    }
}