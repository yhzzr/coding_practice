public class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int p0 = 0;
        int p1 = nums[0];
        int p2 = 0;
        int max = 0;
        
        for(int i=1; i< nums.length; i++){
            p2 = Math.max(p0+nums[i], p1);
            p0 = p1;
            p1 = p2;
            max = Math.max(max, p2);
        }
        
        
        return max;
    }
}