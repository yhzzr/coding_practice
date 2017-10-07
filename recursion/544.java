public class Solution {
    public String findContestMatch(int n) {
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i] = ""+(i+1);
        }
        return helper(s);
    }
    
    private String helper(String[] s){
        int len = s.length;
        if(len==1) return s[0];
        String[] n = new String[len/2];
        for(int i=0;i<len/2;i++){
            n[i] = "("+s[i]+","+s[len-1-i]+")";
        }
        return helper(n);
    }
}