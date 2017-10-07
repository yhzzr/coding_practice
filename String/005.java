public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for( int i=0; i<s.length(); i++){
            int c_length = centerLength(s, i);
            int left = i-1;
            int right = i + c_length;
            while( left >=0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
                    left--;
                    right++;
            }
            String sub = s.substring(left+1, right);
            if(sub.length() > result.length()) 
                result = sub;
        }
        return result;
    }
    
    private int centerLength(String s, int index){
        int length = 1;
        while( index + length < s.length() ){
            if( s.charAt(index) == s.charAt( index + length) ) length++;
            else return length;
        }
        return length;
    }
}