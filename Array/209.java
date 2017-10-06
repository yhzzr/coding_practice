public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, length = nums.length+1;
        while(right < nums.length){
            sum += nums[right];
            if(sum >= s){
                while(left<=right && sum>=s)
                    sum -= nums[left++];
                length = Math.min(length, right-left+2);
            }
            right++;
        }
        if(length>nums.length)
            return 0;
        else
            return length;
    }
}