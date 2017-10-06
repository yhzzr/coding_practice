public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int start = lower;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==start) start=nums[i]+1;
            else if(nums[i]>start){
                if(start==nums[i]-1) res.add(""+start);
                else res.add(start+"->"+ (nums[i]-1));
                start=nums[i]+1;
            }
            if(start<nums[i]) return res; // check boundary cases (Maximum Integer)
        }
        if(upper>=start){
            if(start==upper) res.add(""+start);
            else res.add(start+"->"+upper);
        }
        return res;
    }
}