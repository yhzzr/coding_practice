public class HitCounter {

    HashMap<Integer,Integer> map;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, map.containsKey(timestamp)?map.get(timestamp)+1:1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for(int i=(timestamp-299>0?timestamp-299:1);i<=timestamp;i++){
            if(map.containsKey(i)){
                total += map.get(i);
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */