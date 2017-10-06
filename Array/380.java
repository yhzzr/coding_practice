public class RandomizedSet {

    ArrayList<Integer> keylist;
    HashSet<Integer> set;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        keylist = new ArrayList<>();
        set = new HashSet<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        keylist.add(val);
        set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val))
            return false;
        set.remove(new Integer(val));
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        while(true){
            int i = random.nextInt(keylist.size());
            if(set.contains(keylist.get(i)))
                return keylist.get(i);
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */