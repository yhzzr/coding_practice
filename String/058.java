public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int index = s.length()-1;
        while(index > 0 && s.charAt(index) == ' ')
            index--;
        int end = index;
        while(index >= 0 && s.charAt(index) != ' ')
            index--;
        return end - index;
    }
}