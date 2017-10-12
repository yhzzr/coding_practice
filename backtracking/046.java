public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for(int i=0; i<nums.length;i++)
            inputs.add(nums[i]);
        ArrayList<Integer> list = new ArrayList<Integer>();
        move(result, inputs, list);
        return result;
    }
    
    private void move( List<List<Integer>> result, ArrayList<Integer> inputs, ArrayList<Integer> list){
        if(inputs.isEmpty()){
            result.add(list);
        }else{
            for( Integer i: inputs  ){
                ArrayList sublist = new ArrayList(list);
                ArrayList subinputs = new ArrayList(inputs);
                sublist.add(i);
                subinputs.remove(i);
                move(result, subinputs, sublist);
            }
        }
    }
}