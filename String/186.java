public class Solution {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        int i=0;
        while(i<s.length){
            int j=i;
            while(i<s.length && s[i]!=' '){
                i++;
            }
            reverse(s,j,i-1);
            i++;
        }
    }
    
    public void reverse(char[] s, int l, int r) {
        while (l < r) {
        char tmp = s[l];
        s[l++] = s[r];
        s[r--] = tmp;
        }
    }
}