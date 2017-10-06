public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0;
        int res = 0;
        while(index<nums.length){
            int start = index;
            while(index < nums.length && nums[index]==1){
                index++;
            }
            res = Math.max(res, index-start);
            index++;
        }
        return res;
    }
}