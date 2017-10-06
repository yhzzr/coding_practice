public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, int start){
        res.add(new ArrayList<>(templist));
        for(int i=start;i<nums.length;i++){
            templist.add(nums[i]);
            backtrack(res, templist, nums, i+1);
            templist.remove(templist.size() - 1);
            
            while( i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
        }
    }
}