public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length;i++){
            result = i^nums[i]^result;
        }
        result = result^nums.length;
        return result;
    }
}