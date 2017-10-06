public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        else if(n == 2) return k*k;

        int same = k;
        int different = k*(k-1);
        for(int i=3; i<n+1; i++){
            int newSame = different;
            int newDifferent = same*(k-1) + different*(k-1);
            same = newSame;
            different = newDifferent;
        }
        return same + different;
    }
}