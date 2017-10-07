public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail){
            if(Character.isLetterOrDigit(s.charAt(head)) && Character.isLetterOrDigit(s.charAt(tail))){
                if( Character.toUpperCase(s.charAt(head)) != Character.toUpperCase(s.charAt(tail)))
                    return false;
                else{
                    head++;
                    tail--;
                }
            }else{
                if(!Character.isLetterOrDigit(s.charAt(head))) head++;
                if(!Character.isLetterOrDigit(s.charAt(tail))) tail--;
            }
        }
        return true;
    }
}