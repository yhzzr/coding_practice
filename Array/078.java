public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            backtrack(res, new ArrayList<Integer>(), nums, i);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int s){
        if(s==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[s]);
        for(int i=s+1;i<=nums.length;i++){
            backtrack(res, list, nums, i);
        }
        list.remove(list.size()-1);
    }
}