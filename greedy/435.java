/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length==0) return 0;
        
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });
        
        int end = intervals[0].end;
        int count = 1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start>=end){
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length-count;
    }
}