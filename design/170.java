public class TwoSum {

    private ArrayList<Integer> list = new ArrayList<Integer>();
    
    
    // Add the number to an internal data structure.
	public void add(int number) {
	        list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    for(int i=0; i<list.size(); i++){
	        int key = list.get(i);
	        if( hm.containsKey(key)){
	            return true;
	        }else{
	            int diff = value - key;
	            hm.put(diff, i);
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);