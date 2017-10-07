public class Solution {
    public String countAndSay(int n) {
        if(n == 0) return null;
        String s = "1";
        if(n == 1) return s;
        else{
            for(int i=2; i<=n; i++)
                s = count(s);
        }
        return s;
    }
    
    private String count(String s){
        if(s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char preChar = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if( s.charAt(i) != preChar ){
                sb.append(count);
                sb.append(preChar);
                count = 1;
                preChar = s.charAt(i);
            }else
                count++;
        }
        sb.append(count);
        sb.append(preChar);
        return sb.toString();
    }
}