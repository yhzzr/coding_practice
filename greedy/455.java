public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int people=0, cookie=0;
        while(cookie<s.length && people<g.length){
            if( s[cookie]>= g[people]){
                people++;
            }
            cookie++;
        }
        return people;
    }
}