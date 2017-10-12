public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0) return result;
        
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for(int i=0; i<nums.length;i++)
            inputs.add(nums[i]);
        ArrayList<Integer> list = new ArrayList<Integer>();
        move(set, inputs, list);
        for( List l : set)
            result.add(l);
        return result;
    }
    
    private void move( HashSet<List<Integer>> set, ArrayList<Integer> inputs, ArrayList<Integer> list){
        if(inputs.isEmpty()){
            set.add(list);
        }else{
            for( Integer i: inputs  ){
                ArrayList sublist = new ArrayList(list);
                ArrayList subinputs = new ArrayList(inputs);
                sublist.add(i);
                subinputs.remove(i);
                move(set, subinputs, sublist);
            }
        }
    }
}