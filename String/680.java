class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        
        char[] str = s.toCharArray();
        
        while(l<r && str[l]==str[r]){
            l++;
            r--;
        }
        
        return isValid(str, l+1, r) || isValid(str, l, r-1);
    }
    
    public boolean isValid(char[] s, int l, int r){
        while(l<r){
            if(s[l]!=s[r])
                return false;
            l++;
            r--;
        }
        
        return true;
    }
}