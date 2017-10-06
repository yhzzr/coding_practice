/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i=0;i<n;i++){
            if( knows(candidate,i) && !knows(i, candidate)){
                candidate = i;
            }
        }
        for(int i=0;i<n;i++){
            if( (candidate!=i) && ( knows(candidate, i) || !knows(i,candidate)))
                return -1;
        }
        return candidate;
    }
}