public class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        if( max == 0 && nums.length >1) return false;
        for(int i=1; i<nums.length-1; i++){
            if( i>= max && nums[i] == 0) return false;
            max = Math.max(max, i+nums[i]);
        }
        return true;
    }
}