public class Solution {
    public boolean isSubsequence(String s, String t) {
        //1. Brutal Force
        int i=0, j=0;
        while(i<s.length()){
            while(j<t.length() && s.charAt(i)!=t.charAt(j)){
                j+=1;
            }
            if(j>=t.length())
                return false;
            i+=1;
            j+=1;
        }
        return true;
    }
}