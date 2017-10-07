public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        boolean[] track = new boolean[256];
        for(int i=0; i<256; i++)
            track[i] = false;
            
        int[] index = new int[256];
        int mostRecent = 0;
        
        char[] str = s.toCharArray();
        
        for(int i= 0; i < str.length; i++){
            char a = str[i];
            int length;
            
            if(track[a] && index[a] >= mostRecent) {
                length = i - mostRecent;
                mostRecent = index[a]+1;
            }
            else{
                length = i - mostRecent + 1;
                track[a] = true;
            }
            index[a] = i;
            max = (max < length) ? length : max;
        }
        
        return max;
            
        }
}